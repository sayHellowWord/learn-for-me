package com.yd.modeldiff;

import java.util.Date;

/**
 * Created by nick on 2017/11/13.
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        ModelDiffDemoBean oldBean = new ModelDiffDemoBean(1, Integer.valueOf(1), "test", new Date());
        ModelDiffDemoBean newBean = new ModelDiffDemoBean(1, Integer.valueOf(2), "test2", new Date());
        ModelDiffUtil.DiffResult diffResult = ModelDiffUtil.modelDiff(oldBean, newBean);
        System.out.println(diffResult.toString());
/*
        Class diffClass = oldBean.getClass();
        Annotation[] annotations = diffClass.getAnnotations();
        for(Annotation annotation : annotations){
            *//*if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }*//*

            System.out.println(annotation.toString());*/
    }

}
