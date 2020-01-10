import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;


public class AppleComparator implements Comparator<Apple>{


    public static void main(String[] args) {

        BiFunction<String, Integer, Apple> appleBiFunction = Apple::new;

        List<Apple> appleList = new ArrayList<>();
        Apple apple = appleBiFunction.apply("green",20);

        Apple apple1 = appleBiFunction.apply("red",10);

        Apple apple2 = appleBiFunction.apply("yellow",30);

        appleList.add(apple);
        appleList.add(apple1);
        appleList.add(apple2);

        //使用参数传递
        appleList.sort(new AppleComparator());

        // 使用匿名类
        Collections.sort(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        // 使用Lambda表达式
        Collections.sort(appleList, (o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));


        // 使用方法引用
        Collections.sort(appleList, Comparator.comparing(Apple::getWeight));
        System.out.println(appleList);
    }

    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}
