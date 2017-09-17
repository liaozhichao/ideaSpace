package com.ocean.lambda;

import com.ocean.beans.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spring on 2017/9/9.
 * 初探Lambda表达式
 */
public class TestLambda {

    List<Employee> employees = new ArrayList<Employee>(){{
        add(new Employee("张三",24,5000.0));
        add(new Employee("李四",50,99300.0));
        add(new Employee("王五",36,18934.0));
        add(new Employee("丁七",15,3000.0));
        add(new Employee("赵六",8,1200.0));
    }};

    //优化方式4、Stream API
    @Test
    public void test5(){
        employees.stream()
                 .filter((e)->e.getAge()>35)
                 .forEach(System.out::println);
    }

    //优化方式3、Lambda表达式
    @Test
    public void test4(){
        List<Employee> emps = filterEmployee(employees,(e)->e.getSalary()>2000);
        for (Employee emp : emps){
            System.out.println(emp);
        }
    }

    //优化方式2、使用策略模式+匿名内部类
    @Test
    public void test3(){
        List<Employee> emps = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean filterEmployee(Employee employee) {
               return employee.getAge()>35;
            }
        });
        for (Employee emp : emps){
            System.out.println(emp);
        }
    }

    //1.优化方式一、使用策略模式
    @Test
    public void test2(){
        List<Employee> emps = filterEmployee(employees,new FilterEmpByAge());
        for (Employee emp : emps){
            System.out.println(emp);
        }
    }

    //过滤员工,使用策略模式
    public List<Employee> filterEmployee(List<Employee> emps,MyPredicate<Employee> filter){
        List<Employee> employees = new ArrayList<Employee>();
        for (Employee emp : emps){
            if(filter.filterEmployee(emp)){
                employees.add(emp);
            }
        }
        return employees;
    }


    //获取年龄大于35的所有员工信息,jdk1.8以前的做法
    public List<Employee> listEmployeeByAge(List<Employee> list,Integer age){
        List<Employee> emps = new ArrayList<Employee>();
        for(Employee emp : list) {
            if (emp.getAge() > age) {
                emps.add(emp);
            }
        }
        return emps;
    }






}
