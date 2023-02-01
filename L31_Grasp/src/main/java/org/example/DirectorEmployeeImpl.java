package org.example;

import java.util.ArrayList;
import java.util.List;

public class DirectorEmployeeImpl extends Employee {
    private Double salary = salary();

    static final List<Employee> personalOnDirector = new ArrayList<>();

    public DirectorEmployeeImpl(String firstName, String secondName, Integer experience) {
        super(firstName, secondName, experience, Position.DIRECTOR);
    }

    @Override
    public Double salary() {
        return super.salary()*getPersonalSize();
    }

    Employee hire(Employee employee) {
        personalOnDirector.add(employee);
        this.salary = salary();
        return employee;
    }

    public Double getSalary() {
        return salary;
    }
    public Double getPersonalSize(){
        Double size = (double) personalOnDirector.size();
        if (size == 0){
            return 1.0;
        } else {
            return size;
        }
    }

    @Override
    public String toString() {
        return "DirectorEmployeeImpl\t{" +
                "firstName = '" + super.getFirstName() + '\'' +
                ", secondName = '" + super.getSecondName() + '\'' +
                ", salary = " + salary +
                '}';
    }
}
