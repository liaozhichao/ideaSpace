package com.ocean.stream;

import com.ocean.beans.Employee;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: spring
 * @Description:测试java8的流
 * @Date: Created in 2017/9/14 21:32
 */
public class TestStream {

    List<Employee> employees = new ArrayList<Employee>(){{
        add(new Employee("张三",24,5000.0));
        add(new Employee("李四",50,99300.0));
        add(new Employee("王五",36,18934.0));
        add(new Employee("丁七",15,3000.0));
        add(new Employee("赵六",8,1200000.0));
        add(new Employee("赵六",8,1200000.0));
        add(new Employee("赵六",8,1200000.0));
    }};

    /**
     * 收集操作,将流转换为常用的收集器
     */
    @Test
    public void test6(){
        List<String> list = employees.stream()
                                     .map(Employee::getName)
                                     .collect(Collectors.toList());
        list.forEach(System.out::println);


    }

    /**
     * 归约:将流中的元素反复结合起来得到一个值
     */

    @Test
    public void test5(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer sum = list.stream().reduce(0,(x,y)->x+y);
        System.out.println(sum);

        Optional<Double> op = employees.stream()
                                         .map(Employee::getSalary)
                                         .reduce(Double::sum);
        System.out.println(op.get());
    }
    /**
     * 查找与匹配
     */

    /**
     * 排序
     * 自然排序:comparable 按照对象实现Comparable方法排序
     * 定制排序:按照自定义Comparator定制排序
     */
    @Test
    public void test4(){
        employees.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }

    /**
     * 映射
     * 1.map:接收一个行为参数,应用到每个元素上,将元素转换为其他形式获取信息。
     * 2.flatMap:接收一个行为参数,将流中个每个元素都转换为另一个流,再合并为一个流。
     */
    @Test
    public void test3(){
    }

    /**
     * filter:过滤3
     * limit:前n个值
     * skip:跳过前n个
     * distinct:根据hashCode()和equals()方法判断是否重复
     * 惰性求值:如果没有执行终止操作那么不会进行求值
     * 短路:如果找到了满足条件的数据,后续的操作就不再进行了
     */
    @Test
    public void test2(){
        employees.stream()
                .filter((e) -> e.getSalary()>2000)
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test1(){
        employees.stream()
                 .filter((e) -> e.getAge()>35)
                 .map((e)->e.getName()+":"+e.getSalary())
                 .forEach(System.out::println);
    }
}
