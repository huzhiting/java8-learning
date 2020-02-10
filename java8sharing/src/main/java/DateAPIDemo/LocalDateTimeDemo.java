package DateAPIDemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //2014-03-18T13:45:20
        //构造日期时间（年、月、日、时、分、秒）
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        System.out.println(dt1);
        //构造日期（年、月、日）
        LocalDate date = LocalDate.of(2014, 3, 18);
        //构造时间（时、分、秒）
        LocalTime time = LocalTime.of(13, 45, 20);
        //构造日期时间（日期LocalDate、时间LocalTime）
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println(dt2);
        //日期基础上构造时间（时、分、秒）
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        System.out.println(dt3);
        //日期基础上构造时间（LocalTime）
        LocalDateTime dt4 = date.atTime(time);
        System.out.println(dt4);
        //时间基础上构造日期（LocalDate）
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt5);

        LocalDate date1 = dt1.toLocalDate();
        System.out.println(date1);
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(time1);
    }
}
