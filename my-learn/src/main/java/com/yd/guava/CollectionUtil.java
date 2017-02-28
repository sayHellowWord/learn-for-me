package com.yd.guava;

import com.google.common.collect.*;
import com.yd.guava.bean.Foo;

/**
 * Created by Administrator on 2016/12/30.
 */
public class CollectionUtil {

    public static void main(String[] args) {

        //排序去重
        System.out.println(ImmutableSortedSet.of("a", "b", "c", "a", "d", "b"));

        System.out.println(ImmutableClassToInstanceMap.of(Foo.class, new Foo()));

        //词频统计
        HashMultiset hashMultiset = HashMultiset.create();
        hashMultiset.addAll(ImmutableList.of("a", "b", "c", "a", "d", "b"));
        System.out.println(hashMultiset.count("a"));


        //Multimap
        ListMultimap listMultimap =  ArrayListMultimap.create();

        listMultimap.put("a","1");
        listMultimap.put("a","2");
        listMultimap.put("a","3");
        listMultimap.put("a","3");
        listMultimap.put("b","3");
        System.out.println(listMultimap.get("a"));
        System.out.println(listMultimap.asMap());
        System.out.println(listMultimap.size());
        System.out.println(listMultimap.keySet().size());

    }

}
