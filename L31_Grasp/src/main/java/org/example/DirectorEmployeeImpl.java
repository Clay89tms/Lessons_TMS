package org.example;

import java.util.ArrayList;
import java.util.List;

public class DirectorEmployeeImpl extends Employee {

    static final List<Employee> personalOnDirector = new ArrayList<>();


    Employee employee;

    public DirectorEmployeeImpl(String firstName, String secondName, Integer experience, Position position) {
        super(firstName, secondName, experience, position);
    }


    @Override
    public Double salary(Integer baseRate) {
        return super.salary(baseRate);
    }

    private void hire()

//    @Override
//    public Employee hire(String firstName, String secondName, Integer experience, Position position) {
//        if (position == Position.DIRECTOR) {
//            employee.hire(firstName, secondName, experience, position);
//            employee = new DirectorEmployeeImpl(firstName, secondName, experience, position);
//        } else if (position == Position.WORKER) {
//            employee = new WorkerEmployeeImpl(firstName, secondName, experience, position);
//        }
//        personalOnDirector.add(employee);
//
//        return employee;
//    }
}
