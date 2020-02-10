package OptionalDemo;

import java.util.Optional;

public class NullDemo {

//    public class Person {     private Car car;     public Car getCar() { return car; } }
//
//    public class Car {     private Insurance insurance;     public Insurance getInsurance() { return insurance; } }
//
//    public class Insurance {     private String name;     public String getName() { return name; } }

    //public String getCarInsuranceName(Person person) {     return person.getCar().getInsurance().getName(); }

//    public String getCarInsuranceName(Person person) {
//        if (person != null) {
//            Car car = person.getCar();
//            if (car != null) {
//                Insurance insurance = car.getInsurance();
//                if (insurance != null) {
//                    return insurance.getName();
//                }
//            }
//        }
//        return "Unknown";
//    }

      //过多的退出语句
//    public String getCarInsuranceName(Person person) {
//        if (person == null) {
//            return "Unknown";
//        }
//        Car car = person.getCar();
//        if (car == null) {
//            return "Unknown";
//        }
//        Insurance insurance = car.getInsurance();
//        if (insurance == null) {
//            return "Unknown";
//        }
//        return insurance.getName();
//    }


    public class Person {     private Optional<Car> car;      public Optional<Car> getCar() { return car; } }

    public class Car {     private Optional<Insurance> insurance;      public Optional<Insurance> getInsurance() { return insurance; } }

    public class Insurance {     private String name;      public String getName() { return name; }  }


    public static void main(String[] args) {

        Optional<String> myValue = Optional.of("20200202");
        Optional<String> longName = myValue.filter((value) -> value.length() > 6);

        System.out.println(longName.orElse("The name is less than 6 characters"));//输出OptionalTest

        //另一个例子是Optional值不满足filter指定的条件。
        Optional<String> anotherName = Optional.of("Test");
        Optional<String> shortName = anotherName.filter((value) -> value.length() > 6);
        //输出：name长度不足6字符
        System.out.println(shortName.orElse("The name is less than 6 characters"));

    }


}
