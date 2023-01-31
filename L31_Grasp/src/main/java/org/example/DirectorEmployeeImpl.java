package org.example;

import java.util.ArrayList;
import java.util.List;

public class DirectorEmployeeImpl extends Employee {
    private Double salary;

    static final List<Employee> personalOnDirector = new ArrayList<>();

    public DirectorEmployeeImpl(String firstName, String secondName, Integer experience) {
        super(firstName, secondName, experience, Position.DIRECTOR);
    }

    Employee hire(Employee employee) {
        personalOnDirector.add(employee);
        this.salary = salary();
        return employee;
    }

    public Double getSalary() {
        return salary;
    }
}
