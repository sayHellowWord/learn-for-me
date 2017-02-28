package com.yd.lambda;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/2/22.
 */
public class LambdaTest {

    public static void main(String[] args) {

       /* Runnable sleeper = () -> {
            System.out.println("Zzz");
        };

        new Thread(sleeper).start();

        List strings = Arrays.asList("1","23","11");

        strings.forEach(System.out :: println);
*/

        List<String> words = new ArrayList<String>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int length = random.nextInt(5);
            StringBuffer word = new StringBuffer();
            for (int j = 0; j < length + 1; j++) {
                word.append(j);
            }
            words.add(word.toString());
        }

        System.out.println("words : " + words);
        Stream<String> stream = words.stream().filter(w -> w.length() > 2);
        System.out.println("words > 2 : " + Arrays.asList(stream.map(String::toLowerCase).toArray()));
       /* long count =stream.count();
        System.out.println("count : " + count);*/

        //并发
        long count = words.parallelStream().filter(w -> w.length() > 2).count();
        System.out.println("count : " + count);

        Stream<Double> randoms = Stream.generate(Math::random).limit(10);
        System.out.println("randoms :  " + Arrays.asList(randoms.toArray()));

        //打印过程
        Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();
        System.out.println("powers :  " + Arrays.asList(powers));

        //排序
        Stream<String> wordsStream = words.stream();
        Stream<String> longestFirst = wordsStream.sorted(Comparator.comparing(String::length).reversed());
        System.out.println("longestFirst :  " + Arrays.asList(longestFirst.toArray()));

        //聚合 count max min
        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
        if (largest.isPresent())
            System.out.println("largest : " + largest.get());

        Optional<String> startsWithO = words.stream().filter(s -> s.startsWith("0")).findFirst();
        if (startsWithO.isPresent())
            System.out.println("startsWithO : " + startsWithO.get());


        Optional<String> startsWithOs = words.stream().parallel().filter(s -> s.startsWith("0")).findAny();
        if (startsWithO.isPresent())
            System.out.println("startsWithOs : " + startsWithOs.get());

        boolean aWordStartsWithO = words.stream().parallel().anyMatch(s -> s.startsWith("0"));
        if (aWordStartsWithO)
            System.out.println("aWordStartsWithO : ");







    }


}
