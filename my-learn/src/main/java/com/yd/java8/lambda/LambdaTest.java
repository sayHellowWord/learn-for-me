package com.yd.java8.lambda;

import com.yd.java8.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by nick on 2018/1/28.
 *
 * @author nick
 * @date 2018/1/28
 */
public class LambdaTest {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );


    //策略设计模式
    @Test
    public void test1() {
        List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //匿名内部类
    @Test
    public void test2() {
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean command(Employee t) {
                return t.getId() <= 103;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void test3() {
        List<Employee> list = filterEmployee(emps, employee ->
                employee.getId() <= 103
        );

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    //优化方式四：Stream API
    @Test
    public void test4(){
        emps.stream()
                .filter((e) -> e.getAge() <= 35)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .limit(10)
                .sorted()
                .forEach(System.out::println);
    }

    //对象的引用 :: 实例方法名
    @Test
    public void test5(){
        Employee emp = new Employee(101, "张三", 18, 9999.99);

        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        System.out.println("----------------------------------");

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee : emps) {
            if (mp.command(employee)) {
                list.add(employee);
            }
        }

        return list;
    }
}
