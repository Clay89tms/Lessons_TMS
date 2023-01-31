package org.example;

public class WorkerEmployeeImpl extends Employee {
    public WorkerEmployeeImpl(String firstName, String secondName, Integer experience) {
        super(firstName, secondName, experience, Position.WORKER);
    }

    @Override
    public Double salary() {
        return super.salary();
    }

    //    @Override
//    Double salary(Integer baseRate) {
//        return (double) baseRate;
//    }

}
