import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamDemo {

    public static void main(String[] args) {

//        long sum = iterativeSum(10);
//        System.out.println(sum);

//        long sumStream = sequentialSum(20);
//        System.out.println(sumStream);

//        long parallelSum = parallelSum(20);
//        System.out.println(parallelSum);

//        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStreamDemo::sequentialSum, 10_000_000) + " msecs");

//        System.out.println("Iterative sum done in:" +     measureSumPerf(ParallelStreamDemo::iterativeSum, 10_000_000) + " msecs");

//        System.out.println("Parallel sum done in: " +     measureSumPerf(ParallelStreamDemo::parallelSum, 10_000_000) + " msecs" );

//        System.out.println("Ranged sum done in: " +     measureSumPerf(ParallelStreamDemo::rangedSum, 10_000_000) + " msecs" );

        System.out.println("Parallel range sum done in: "  +     measureSumPerf(ParallelStreamDemo::parallelRangedSum, 10_000_000) + " msecs" );
    }

    /**
     * 传统方式实现，1-10的求和
     * @param n
     * @return
     */
    public static long iterativeSum (long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;     }
        return result;
    }

    /**
     * java8 Stream.iterate顺序流处理
     * @param n
     * @return
     */
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    /**
     * java8 Stream.iterate并行流处理
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }


    /**
     * 性能测试-计算耗时
     * @param adder
     * @param n
     * @return
     */
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    /**
     * java8 LongStream.rangeClosed顺序流处理
     * @param n
     * @return
     */
    public static long rangedSum(long n) {
        return  LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    /**
     * java8 LongStream.rangeClosed并行流处理
     * @param n
     * @return
     */
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }
}
