package com.ocean.lambda;

import com.ocean.beans.Employee;

/**
 * Created by spring on 2017/9/10.
 */
public class FilterEmpByAge implements MyPredicate<Employee> {
    @Override
    public boolean filterEmployee(Employee employee) {
      return employee.getAge()>35;
    }
}
