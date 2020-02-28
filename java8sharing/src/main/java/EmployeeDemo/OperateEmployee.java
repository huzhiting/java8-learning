package EmployeeDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperateEmployee {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("张三",22, 3900.00),
                new Employee("李四",23,2300.00),
                new Employee("赵六",42, 6999.00),
                new Employee("刘武",42,5999.00),
                new Employee("路易",33,5899.00),
                new Employee("未立",35,4890.00));

        //获取年龄大于35的员工
        List<Employee> employeeList = filterEmployee(employees);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.println("------------------------------------------");

        //获取工资大于5000的员工
        List<Employee> employees1 = filterEmployeeSalary(employees);
        for (Employee employee : employees1) {
            System.out.println(employee);
        }

        System.out.println("-------------优化方式1策略模式：筛选年龄----------------");
        //优化方式一策略模式：筛选年龄
        List<Employee> employees2 = filterEmployee(employees,new filterEmployeeByAge());
        for (Employee employee : employees2) {
            System.out.println(employee);
        }
        //优化方式一策略模式：筛选工资
        System.out.println("-------------优化方式1策略模式：筛选工资----------------");
        List<Employee> employees3 = filterEmployee(employees,new filterEmployeeBySalary());
        for (Employee employee : employees3) {
            System.out.println(employee);
        }

        System.out.println("-------------优化方式2匿名内部类：筛选工资----------------");
        //优化方式二匿名内部类：筛选工资
        List<Employee> employees4 = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
        for (Employee employee : employees4) {
            System.out.println(employee);
        }

        System.out.println("-------------优化方式3Lambda：筛选工资----------------");
        //优化方式三Lambda表达式：筛选工资
        List<Employee> employees5 = filterEmployee(employees,(e) -> e.getSalary()<=3000);
        employees5.forEach(System.out::println);

        System.out.println("-------------优化方式4Stream流操作：筛选工资----------------");
        //优化方式四Stream流操作：筛选工资
        employees.stream()
                .filter(employee -> employee.getSalary()>3000)
                .limit(2)
                .forEach(System.out::println);
    }

    //获取年龄大于35的员工信息
    public static List<Employee> filterEmployee(List<Employee> list){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee:list) {
            if(employee.getAge() > 35){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    //获取工资大于5000的员工信息
    public static List<Employee> filterEmployeeSalary(List<Employee> list){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee:list) {
            if(employee.getSalary() > 5000){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    //优化方式一：设计模式
    public static List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mps){
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : list) {
            if(mps.test(employee)){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }



}
