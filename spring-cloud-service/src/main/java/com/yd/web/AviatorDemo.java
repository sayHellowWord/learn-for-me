package com.yd.web;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nick on 2017/11/2.
 */
public class AviatorDemo {
    public static void main(String[] args) {
        String expression = "a-(b-c)>100";

//        String expression = "a>0? 'yes':'no'";

        // 编译表达式
        Expression compiledExp = AviatorEvaluator.compile(expression);
//        AviatorEvaluator.setOption(Options.TRACE, true);


        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);
        // 执行表达式
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);  // false

        System.out.println(AviatorEvaluator.exec("a>0? b>0? '111':'222':'no'", 1,-1));

/*
        Map<String, Object> env = new HashMap<String, Object>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(100);
        list.add(-100);
        env.put("list", list);
        System.out.println(AviatorEvaluator.execute("sort(list)", env));
        System.out.println(list);*/
    }
}
