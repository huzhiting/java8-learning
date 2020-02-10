package DateAPIDemo;

import java.time.LocalTime;

public class LocalTimeDemo {

    public static void main(String[] args) {
        //构造时间（时、分、秒）
        LocalTime time = LocalTime.of(13, 45, 20);
        System.out.println(time);
        //获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        //获取时
        int hour = localTime.getHour();
        System.out.println(hour);
        //获取分
        int minute = localTime.getMinute();
        System.out.println(minute);
        //获取秒
        int second = localTime.getSecond();
        System.out.println(second);
    }
}
