package StreamDemo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class DishJava8Demo {
    public static void main(String[] args) {

        List<Dish> dishes = new ArrayList<>();
        TriFunction<String,Integer,String,Dish> dishFunction = Dish::new;
        dishes.add(dishFunction.apply("鲜奶",163,"100毫升"));
        dishes.add(dishFunction.apply("鸡蛋",75,"1个"));
        dishes.add(dishFunction.apply("玉米",107,"1根"));
        dishes.add(dishFunction.apply("面包",300,"100克"));
        dishes.add(dishFunction.apply("苹果",59,"100克"));
        dishes.add(dishFunction.apply("猪肉",806,"100克"));

        List<String> lowCaloricDishesName =  dishes.stream()
                                            .filter(d -> d.getCalories() < 200)
                                            .sorted(comparing(Dish::getCalories))
                                            .map(Dish::getName).collect(toList());

        System.out.println(lowCaloricDishesName);
    }
}
