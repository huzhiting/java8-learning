package DateAPIDemo;

import java.time.*;

public class ZoneDateTimeDemo {

    public static void main(String[] args) {
        //构造时区
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        //构造日期
        LocalDate date = LocalDate.of(2020, Month.FEBRUARY, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        System.out.println(zdt1);
        LocalDateTime dateTime = LocalDateTime.of(2020, Month.FEBRUARY, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        System.out.println(zdt2);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);
        System.out.println(zdt3);
    }

}
