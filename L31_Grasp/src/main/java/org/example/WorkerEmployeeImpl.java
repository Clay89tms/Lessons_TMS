package org.example;

public class WorkerEmployeeImpl extends Employee {
    public WorkerEmployeeImpl(String firstName, String secondName, Integer experience, Position position) {
        super(firstName, secondName, experience, position);
    }

    @Override
    public Double salary(Integer baseRate) {
        return super.salary(900);
    }
}
