package com.yd.guava;


import com.google.common.collect.Ordering;
import com.yd.guava.bean.Foo;

/**
 * 基本工具
 */
public class BaseUtil {

    public static void main(String[] args) {

        System.out.println(new BaseUtil().toString());

        Ordering.usingToString();

        Foo foo = new Foo();

        System.out.println(foo.toString());

    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this).add("x",1).toString();
    }
}
