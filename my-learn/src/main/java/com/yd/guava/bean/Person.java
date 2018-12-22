package com.yd.guava.bean;

import com.google.gson.Gson;
import lombok.Data;

/**
 * Created by nick on 2018/3/12.
 *
 * @author nick
 * @date 2018/3/12
 */
@Data
public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        Gson gson = new Gson();
        Person user = new Person("zhangsan",26);
        String jsonObject = gson.toJson(user); // {"name":"怪盗kidou","age":24}

        System.out.println(jsonObject);
    }
}
