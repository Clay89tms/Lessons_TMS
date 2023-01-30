package org.example;

public class WorkerEmployeeImpl extends Employee {
    public WorkerEmployeeImpl(String firstName, String secondName, Integer experience, Position position) {
        super(firstName, secondName, experience, position);
    }

    @Override
    Double salary(Integer baseRate) {
        setSalary((double)baseRate);
        return (double) baseRate;
    }

    @Override
    Employee hire(String firstName, String secondName, Integer experience, Position position) {
        System.out.println("!!!--worker can't add personal--!!!");
        return null;
    }
}
