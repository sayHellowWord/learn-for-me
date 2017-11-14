package com.yd.modeldiff;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 2014-11-10 下午01:54:48
 * @version V1.0
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    private String pwd;

    @XmlElement(name = "ID")
    private int id;

    @XmlAttribute
    @XmlElement
    private String name;

    /***
     *  1、获取属性上的指定类型的注解
     *  2、获取属性上的指定类型的注解的指定方法
     *  3、获取属性上的所有注解
     *  4、获取类上的所有注解
     *  5、获取方法上的所有注解
     * @author 2014-11-10 下午02:18:24
     * @param args
     */
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        Field[] fields = User.class.getDeclaredFields();

        for (Field f : fields) {
            String filedName = f.getName();
            System.out.println("属性名称:【" + filedName + "】");

            //1、获取属性上的指定类型的注解
            Annotation annotation = f.getAnnotation(XmlElement.class);

            //有该类型的注解存在
            if (annotation != null) {
                //强制转化为相应的注解
                XmlElement xmlElement = (XmlElement) annotation;
                //3、获取属性上的指定类型的注解的指定方法
                //具体是不是默认值可以去查看源代码
                if (xmlElement.name().equals("##default")) {
                    System.out.println("属性【" + filedName + "】注解使用的name是默认值: " + xmlElement.name());
                } else {
                    System.out.println("属性【" + filedName + "】注解使用的name是自定义的值: " + xmlElement.name());
                }
            }

            //2、获取属性上的所有注解
            Annotation[] allAnnotations = f.getAnnotations();

            for (Annotation an : allAnnotations) {

                Class annotationType = an.annotationType();

                System.out.println("属性【" + filedName + "】的注解类型有: " + annotationType);
            }
            System.out.println("----------华丽的分割线--------------");
        }

        //4、获取类上的所有注解
        Annotation[] classAnnotation = User.class.getAnnotations();

        for (Annotation cAnnotation : classAnnotation) {
            Class annotationType = cAnnotation.annotationType();
            System.out.println("User类上的注解有: " + annotationType);
        }

        System.out.println("----------华丽的分割线--------------");

        // 5、获取方法上的所有注解
        Method method;
        try {
            method = User.class.getMethod("setPwd", String.class);

            Annotation[] methodAnnotations = method.getAnnotations();

            for (Annotation me : methodAnnotations) {
                Class annotationType = me.annotationType();
                System.out.println("setPwd方法上的注解有: " + annotationType);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @XmlElement
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }
}