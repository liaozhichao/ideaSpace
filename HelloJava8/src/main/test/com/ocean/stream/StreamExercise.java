package com.ocean.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: spring
 * @Description:Stream API的练习
 * @Date: Created in 2017/9/16 21:45
 */
public class StreamExercise {
    /**
     * 给定一个数字列表,返回一个由每个数的平方构成的列表
     */
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(19,23,24,90,2,43,10,2);
        List<Integer> resultList = list.stream()
                                       .map((e)->e*e)
                                       .collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }
}
