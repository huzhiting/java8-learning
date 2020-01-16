package CollectDemo;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class CollectOperate {

    public enum CaloricLevel { DIET, NORMAL, FAT }

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", 800,  false, Dish.Type.MEAT),
                new Dish("beef",  700, false, Dish.Type.MEAT),
                new Dish("chicken", 400, false, Dish.Type.MEAT),
                new Dish("french fries", 530, true, Dish.Type.OTHER),
                new Dish("rice", 350,true, Dish.Type.OTHER),
                new Dish("season fruit", 120, true, Dish.Type.OTHER),
                new Dish("pizza", 550, true, Dish.Type.OTHER),
                new Dish("prawns", 300,false, Dish.Type.FISH),
                new Dish("salmon", 450, false, Dish.Type.FISH) );

        //1. 计算总数
        //counting
        long howManyDishes = menu.stream().collect(Collectors.counting());
        System.out.println("1:" + howManyDishes);
        //count
        long howManyDishes2 = menu.stream().count();
        System.out.println("1:" + howManyDishes2);

        //2. 热量最高和最低
        Comparator<Dish> dishCaloriesComparator = comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));
        Optional<Dish> lessCalorieDish = menu.stream().collect(minBy(dishCaloriesComparator));
        System.out.println("2:" + mostCalorieDish);
        System.out.println("2:" + lessCalorieDish);

        //3. 总和
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println("3:" + totalCalories);

        //4. 求平均
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println("4:" + avgCalories);

        //5. 数据统计：总和、平均值、最大值及最小值
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("5:" + menuStatistics);

        //6. 字符串连接
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println("6:" + shortMenu);

        String shortMenuSplit = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println("6:" + shortMenuSplit);

        //7. 按类型分组
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("7:" + dishesByType);

        //8. 按热量分组
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                                                                groupingBy(dish -> {
                                                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                                                    else if (dish.getCalories() <= 700) return     CaloricLevel.NORMAL;
                                                                    else return CaloricLevel.FAT;          } ));
        System.out.println("8:" + dishesByCaloricLevel);

        //9. 多级分组：同时按类型和热量分组
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType,
                groupingBy(dish -> {if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                else return CaloricLevel.FAT;} )) );
        System.out.println("9:" + dishesByTypeCaloricLevel);

        //10. 按子组收集数据
        Map<Dish.Type, Dish> mostCaloricByType =  menu.stream().collect(
                groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)));
        System.out.println("10:" + mostCaloricByType);

        //11. 分区：素食与非素食
        Map<Boolean,List<Dish>> vegetarianDishes = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println("11:" + vegetarianDishes);
        List<Dish> vegetarianList = vegetarianDishes.get(true);
        System.out.println("11:" + vegetarianList);
        //或者直接使用filter
        List<Dish> vegetarianFilter = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println("11:" + vegetarianFilter);


        //12. 先按是否是素食分区，再将结果按类型分组
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream().collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType)));
        System.out.println("12:" + vegetarianDishesByType);



    }


}
