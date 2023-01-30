package org.example;

import java.util.ArrayList;
import java.util.List;

public class DirectorEmployeeImpl extends Employee {
    private Double salary;


    static final List<Employee> personalOnDirector = new ArrayList<>();

    @Override
    Double salary(Integer baseRate) {
        setSalary((double)baseRate);
        baseRate += baseRate*(personalOnDirector.size()/(10));
        return (double) (baseRate);
    }

    Employee employee;

    public DirectorEmployeeImpl(String firstName, String secondName, Integer experience, Position position) {
        super(firstName, secondName, experience, position);
    }
}
