package com.yd.modeldiff;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by nick on 2017/11/13.
 * <p>
 * 对象差异对比-属性注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelDiffProperties {

    /**
     * 忽略此注解属性
     *
     * @return
     */
    boolean ignore() default true;

    /**
     * 属性对比时需要格式化后的对比
     *
     * @return
     */
    String format() default "";

    /**
     * 此属性对比后的文案 默认显示：属性名：变化后值，变化前值
     * demo 业务意义：变化前值%s,变化后值%s;
     *
     * @return
     */
    String desc();


}
