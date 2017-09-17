package com.ocean.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: spring
 * @Description:Java8中内置的四大核心函数式接口
 * @Date: Created in 2017/9/11 22:52
 */
public class TestLambda3 {

    @Test
    public void test4(){
        List<String> list = new ArrayList<String>(){{
            add("green");
            add("Apple");
            add("white");
            add("AO");
            add("HELLLO　WORLD");
        }};
        List<String> newList = filterStr(list,e->e.length()>3);
        newList.stream().forEach(System.out::println);
    }

    //断言型接口
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> newList = new ArrayList<>();
        for(String str : list){
            if(predicate.test(str)){
                newList.add(str);
            }
        }
        return newList;
    }

    //函数型接口
    @Test
    public void test3(){
        System.out.println(strHandler("天涯何处无芳草",e -> e.substring(2,5)));
    }

    //函数型接口:用于处理字符串
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    //供给型接口
    @Test
    public void test2(){
        List list = getNumList(10,()->new Random(56).nextInt());
        list.stream().forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<num;i++){
            list.add(sup.get());
        }
        return list;
    }

    //消费型接口
    @Test
    public void test1(){
        happy(10000,(m)-> System.out.println("消费大保健"+m+"元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
}
