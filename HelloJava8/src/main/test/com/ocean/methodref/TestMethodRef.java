package com.ocean.methodref;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * @Author: spring
 * @Description:方法引用
 * @Date: Created in 2017/9/12 21:09
 */

/*
方法引用:如果Lambda体中的内容已经有方法实现了,我们可以使用方法引用,方法引用可以说是Lambda表达式的另外一种形式
一、方法引用主要有三种语法格式
1、对象::实例方法名
2、类::静态方法名
3、类::实例方法名、如果参数列表中第一个参数是方法的调用者、第二个参数是方法的参数时才可以如此调用
 */
public class TestMethodRef {

    @Test
    public void test1(){
        Consumer<String> con = (x)-> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

    }




















}
