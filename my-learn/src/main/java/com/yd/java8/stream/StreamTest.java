package com.yd.java8.stream;

import com.yd.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2017/2/23.
 */
public class StreamTest {


    List<Employee> employees = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    public static void main(String[] args) {

        //新建stram方法
//        Stream.of()
//        Arrays.stream()
//        Stream.empty()


    }

    /*
   * 归约
   * reduce(T identity,BinaryOperator b) / reduce(BinaryOperator b)-可以将流中元素反复结合起来，得到一个值。
   */
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()//reduce(T identity,BinaryOperator b)
                .reduce(0, (x, y) -> x + y);//0为起始值
        System.out.println(sum);

        System.out.println("--------------------------");

        Optional<Double> op = employees.stream()//reduce(BinaryOperator b)//没有起始值，map返回可能为空，所以返回Optional类型
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }

}
