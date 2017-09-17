package com.ocean.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Author: spring
 * @Description:
 * @Date: Created in 2017/9/10 22:22
 */
public class TestLambda2 {
    /*
    一、Lambda中引入了一个箭头操作符
    1、箭头操作符将表达式拆分成了左右两个部分
    2、左侧:Lambda代表参数列表,对应的是接口中抽象方法的参数
    3、右侧:Lambda表示要进行的操作(Lambda体),对应的是接口中抽象方法的实现
    二、如果有多个抽象方法、Lambda表达式应该实现哪个?
       :使用函数式接口
    三、格式口诀:
     左右遇一类型省
     左侧推断类型省
       能省则省
    四、函数式接口:若接口中只有一个抽象方法时、则称为函数式接口。可以使用@FunctionalInterface
   */

    @Test
    public void test5(){
        System.out.println(operation(5,x->x*x));
    }

    public Integer operation(Integer num,MyInterface mi){
       return mi.getValue(num);
    }

    //4、如果只有一条语句、大括号和return都可以不写
    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    }

    //3、两个以上个参数无返回值、Lambda体中有多条语句、必须使用大括号{
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y) -> {
            System.out.println("Lambda体中使用大括号");
            return Integer.compare(x,y);
        };
    }


    //2、有一个参数且无返回值的方法
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("天空之城在哭泣");
    }

    //1、无参数且无返回值的方法:()->System.out.println();
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 : Hello World!!!");
            }
        };
        r1.run();

        Runnable r2 = ()-> System.out.println("Thread2 : Hello World!!!");
        r2.run();
    }

}
