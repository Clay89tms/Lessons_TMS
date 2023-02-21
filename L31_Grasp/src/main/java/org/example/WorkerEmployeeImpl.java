package org.example;

public class WorkerEmployeeImpl extends Employee {

    public WorkerEmployeeImpl(String firstName, String secondName, Integer experience) {
        super(firstName, secondName, experience, Position.WORKER);
    }
}
