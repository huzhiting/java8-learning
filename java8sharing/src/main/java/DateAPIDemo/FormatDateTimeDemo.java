package DateAPIDemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDateTimeDemo {
    public static void main(String[] args) {
        //构造日期（年、月、日）
        LocalDate date = LocalDate.of(2020, 2, 18);
        System.out.println(date);
        //格式化日期：20200218
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(s1);
        //格式化日期：2020-02-18
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s2);

        LocalDate date1 = LocalDate.parse("20200206",DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(date1);
        LocalDate date2 = LocalDate.parse("2020-02-06",DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //构造日期
        LocalDate date3 = LocalDate.of(2020, 2, 18);
        System.out.println(date3);
        //转换为dd/MM/yyyy模式日期
        String formattedDate = date3.format(formatter);
        System.out.println(formattedDate);
        //dd/MM/yyyy模式日期解析为LocalDate
        LocalDate date4 = LocalDate.parse(formattedDate, formatter);
        System.out.println(date4);
    }
}
