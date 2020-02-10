package DateAPIDemo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateDemo {

    public static void main(String[] args) {
        //构造日期（年，月，日）
        LocalDate date = LocalDate.of(2014, 3, 18);
        System.out.println(date);
        //获取当前日期
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);
        //获取年份
        int year = nowDate.getYear();
        System.out.println(year);
        //获取月份
        Month month = nowDate.getMonth();
        System.out.println(month);
        //获取日
        int day = nowDate.getDayOfMonth();
        System.out.println(day);
        //获取星期
        DayOfWeek dow = nowDate.getDayOfWeek();
        System.out.println(dow);
        //获取本月的天数
        int len = nowDate.lengthOfMonth();
        System.out.println(len);
        //判断是否是闰年
        boolean leap = nowDate.isLeapYear();
        System.out.println(leap);

        int year2 = date.get(ChronoField.YEAR);
        System.out.println(year2);
        int month2 = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println(month2);
        int day2 = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day2);
    }
}
