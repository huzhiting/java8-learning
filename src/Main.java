import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //示例1 (String s) -> s.length()
        List<String> list = new ArrayList<>();
        list.add("December");
        list.add("last day");
        list.add("hello world");
        list.forEach((String s) -> System.out.println(s.length()));

        //示例2 (Apple a) -> a.getWeight() > 150
        List<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Apple apple = new Apple();
            apple.setNo(i);
            apple.setWeight(50 + i);
            apples.add(apple);
        }
        apples.forEach((apple -> System.out.println(apple.getWeight()>50)));

        //示例3两数的加减乘除
        // 类型声明
        MathOperation addition = (int x,int y) -> x+y;
        // 不用类型声明
        MathOperation subtraction = (x, y) -> x - y;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println(addition.operation(15,5));
        System.out.println(subtraction.operation(15,5));
        System.out.println(multiplication.operation(15,5));
        System.out.println(division.operation(15,5));
//
//        //示例4：排序
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person("David",33);
        Person p2 = new Person("David",16);
        personList.add(p1);
        personList.add(p2);
//        //按名称排序
        Comparator<Person> byName =
                Comparator.comparing(Person::getName);
//
//        //名称相同，按年龄排序
        personList.sort((o1,o2)->{
            if(o1.getName().equals(o2.getName())){
               System.out.println(o1.getAge() - o2.getAge());
            }else{
                System.out.println(o1.getName().compareTo(o2.getName()));
            }
            return 1;
        });
    }

    interface MathOperation {
        int operation(int a, int b);
    }




}
