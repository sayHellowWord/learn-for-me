package com.yd.modeldiff;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nick on 2017/11/13.
 * <p>
 * 对象差异对比-对象注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelDiffBean {

    /**
     * 忽略此注解对象【存在引用类型有用】
     *
     * @return
     */
    boolean ignore() default false;

    /**
     * 是否扫描标记类的所有属性
     *
     * @return
     */
    boolean scanAllProperties() default true;

}
