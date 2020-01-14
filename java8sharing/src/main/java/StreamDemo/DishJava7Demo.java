package StreamDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class DishJava7Demo {
    public static void main(String[] args) {

        List<Dish> dishes = new ArrayList<>();
        TriFunction<String,Integer,String,Dish> dishFunction = Dish::new;
        dishes.add(dishFunction.apply("鲜奶",163,"100毫升"));
        dishes.add(dishFunction.apply("鸡蛋",75,"1个"));
        dishes.add(dishFunction.apply("玉米",107,"1根"));
        dishes.add(dishFunction.apply("面包",300,"100克"));
        dishes.add(dishFunction.apply("苹果",59,"100克"));
        dishes.add(dishFunction.apply("猪肉",806,"100克"));

        List<Dish> lowCaloricDishes = new ArrayList<>();
        //遍历筛选卡路里低于200的食物
        for(Dish d: dishes)
        {
            if(d.getCalories() < 200){
                lowCaloricDishes.add(d);
            }
        }
        //将筛选出来的食物按卡路里高低排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        //遍历得到低卡路里的食物名称
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        System.out.println(lowCaloricDishesName);

    }
}
