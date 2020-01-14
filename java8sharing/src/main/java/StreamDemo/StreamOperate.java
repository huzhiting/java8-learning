package StreamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamOperate {

    public static void main(String[] args) {

        List<Food> menu = Arrays.asList(
                new Food("pork", false, 800, Food.Type.MEAT),
                new Food("beef", false, 700, Food.Type.MEAT),
                new Food("chicken", false, 400, Food.Type.MEAT),
                new Food("french fries", true, 530, Food.Type.OTHER),
                new Food("rice", true, 350, Food.Type.OTHER),
                new Food("season fruit", true, 120, Food.Type.OTHER),
                new Food("pizza", true, 550, Food.Type.OTHER),
                new Food("prawns", false, 300, Food.Type.FISH),
                new Food("salmon", false, 450, Food.Type.FISH) );

        //filter（筛选所有素食）
        List<Food> vegetarianMenu = menu.stream().filter(Food::isVegetarian) .collect(toList());
        System.out.println(vegetarianMenu.toString());

        // distinct（筛选所有偶数，并去重）
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        //limit（筛选卡路里大于300的三种食物）
        List<Food> foods = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println(foods.toString());

        //skip（跳过前两个卡路里大于300的食物，返回剩下的）
        List<Food> foodList = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println(foodList.toString());

        //前两个荤菜
        List<Food> meats = menu.stream()
                .filter(d -> d.getType() == Food.Type.MEAT)
                .limit(2)
                .collect(toList());
        System.out.println(meats);

        //map（提取所有食物的名称）
        List<String> dishNames = menu.stream().map(Food::getName).collect(toList());
        System.out.println(dishNames);

        //map (获取字符串数组中每个元素的字符长度）
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                                         .map(String::length)
                                         .collect(toList());
        System.out.println(wordLengths);

        //map（获取所有食物名称的长度）
        List<Integer> dishNameLengths = menu.stream()
                                            .map(Food::getName)
                                            .map(String::length)
                                            .collect(toList());
        System.out.println(dishNameLengths);

        //map（不正确的返回所有不相同的字符）
        List<String> wordList = Arrays.asList("Hello","World");
        List<String[]> allWord = wordList.stream()
                                         .map(word -> word.split(""))
                                         .distinct()
                                         .collect(toList());
        System.out.println(allWord);

        //flatMap（输出所有不相同的字符）
        List<String> uniqueCharacters = wordList.stream()
                                             .map(w -> w.split(""))
                                             .flatMap(Arrays::stream)
                                             .distinct()
                                             .collect(Collectors.toList());
        System.out.println(uniqueCharacters);

        //anyMatch
        if(menu.stream().anyMatch(Food::isVegetarian)){     System.out.println("The menu is (somewhat) vegetarian friendly!!"); }

        //allMatch
        boolean isHealthy1 = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy1);

        //noneMatch
        boolean isHealthy2 = menu.stream().noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy2);

        //findAny
        Optional<Food> food =menu.stream().filter(Food::isVegetarian).findAny();
        System.out.println(food);

        //findFirst
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                                                                   .map(x -> x * x)
                                                                   .filter(x -> x % 3 == 0)
                                                                   .findFirst(); // 9
        System.out.println(firstSquareDivisibleByThree);

        //遍历求和
        int sum1 = 0; for (int x : someNumbers) {     sum1 += x; }
        System.out.println(sum1);
        //reduce求和
        int sum2 = someNumbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum2);

        //最大值
        Optional<Integer> max = someNumbers.stream().reduce(Integer::max);
        System.out.println(max);

        //最小值
        Optional<Integer> min = someNumbers.stream().reduce(Integer::min);
        System.out.println(min);


    }

}
