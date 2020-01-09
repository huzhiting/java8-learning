import java.util.function.Function;

public class FunctionDemo {

    public static Integer calculate(Function<Integer,Integer> test,Integer number){
        return test.apply(number);
    }

    public static void main(String[] args) {
        //示例1：输入一个数，结果返回此数+1
//        Function<Integer,Integer> test= i-> {
//            System.out.println(i + 1);
//            return i;
//        };
//        test.apply(5);

        //示例2：通过传入不同的Function，实现了在同一个方法中实现不同的操作。
        Function<Integer,Integer> test1=i->i+1;
        Function<Integer,Integer> test2=i->i*i;
        System.out.println(calculate(test1,5));
        System.out.println(calculate(test2,5));
    }
}
