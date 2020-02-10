package DateAPIDemo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class OperateDateTimeDemo {
    public static void main(String[] args) {
        //构造日期（年、月、日）
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        System.out.println(date1);
        //变更年
        LocalDate date2 = date1.withYear(2011);
        System.out.println(date2);
        //变更日
        LocalDate date3 = date2.withDayOfMonth(25);
        System.out.println(date3);
        //变更月
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(date4);
        //构造日期（年、月、日）
        LocalDate date5 = LocalDate.of(2014, 3, 18);
        System.out.println(date5);
        //加一周
        LocalDate date6 = date5.plusWeeks(1);
        System.out.println(date6);
        //减3年
        LocalDate date7 = date6.minusYears(3);
        System.out.println(date7);
        //加6个月
        LocalDate date8 = date7.plus(6, ChronoUnit.MONTHS);
        System.out.println(date8);
        //构造日期（年、月、日）
        LocalDate date9 = LocalDate.of(2020, 2, 9);
        System.out.println(date9);
        //周日
        LocalDate date10 = date9.with(nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(date10);
        //本月最后一天
        LocalDate date11 = date10.with(lastDayOfMonth());
        System.out.println(date11);
    }
}
