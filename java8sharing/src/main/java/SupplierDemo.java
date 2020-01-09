import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Person> supplierPerson = Person::new;
        Person person = supplierPerson.get();
        person.setName("zhangsan");
        System.out.println(person.getName());//zhangsan
    }

}
