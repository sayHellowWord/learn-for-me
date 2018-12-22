package com.yd.java8;

import lombok.Data;

/**
 * Created by nick on 2018/1/28.
 *
 * @author nick
 * @date 2018/1/28
 */
@Data
public class Employee {

    private int id;

    private String name;

    private int age;

    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
