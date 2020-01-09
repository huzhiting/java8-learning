import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }


    public static void main(String[] args) {
        //示例1：传入一个数，返回值为此数+2
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);// 12
        };
        consumer.accept(10);

        //示例2：遍历一个list，返回值为每个数与5的乘积
        forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i * 5) );

    }

}
