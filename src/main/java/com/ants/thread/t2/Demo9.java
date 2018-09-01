package com.ants.thread.t2;

import java.util.Arrays;
import java.util.List;

/**
 * 使用lambda
 * fork join 分而治思想
 */
public class Demo9 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,50,60);
        System.out.println(add(list));
    }
    public static int add(List<Integer> values) {
        //values.parallelStream().forEachOrdered(System.out::println);
        values.parallelStream().forEach(System.out::println);
        return values.parallelStream().mapToInt(i -> i).sum();
    }
}
