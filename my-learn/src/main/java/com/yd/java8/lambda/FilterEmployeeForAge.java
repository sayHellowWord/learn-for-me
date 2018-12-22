package com.yd.java8.lambda;

import com.yd.java8.Employee;

/**
 * Created by nick on 2018/1/28.
 *
 * @author nick
 * @date 2018/1/28
 */
public class FilterEmployeeForAge implements MyPredicate {

    @Override
    public boolean command(Object o) {

        if (o instanceof Employee) {
            return ((Employee) o).getAge() > 10;
        }

        return false;
    }
}
