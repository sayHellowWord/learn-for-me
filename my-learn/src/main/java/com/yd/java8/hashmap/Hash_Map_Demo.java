package com.yd.java8.hashmap;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by nick on 2019/1/28.
 *
 * @author nick
 * @date 2019/1/28
 */
public class Hash_Map_Demo {

    public static void main(String[] args) {
        // Creating an empty HashMap
        HashMap<String, Integer> hash_map1 = new HashMap<String, Integer>();

        // Mapping int values to string keys
        hash_map1.put("Geeks", 10);
        hash_map1.put("4", 15);
        hash_map1.put("Geeks", 20);
        hash_map1.put("Welcomes", 25);
        hash_map1.put("You", 30);

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map1);

        // Using keySet() to get the set view of keys
        Set result =  hash_map1.keySet();
        System.out.println("The set is: " );
    }

}
