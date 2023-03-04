package org.example;

import java.util.ArrayList;
import java.util.List;

public class DirectorEmployeeImpl extends Employee {

    final List<Employee> personalOnDirector = new ArrayList<>();

    public DirectorEmployeeImpl(String firstName, String secondName, Integer experience) {
        super(firstName, secondName, experience, Position.DIRECTOR);
    }

    @Override
    public Double salary() {
        return super.salary() * (personalOnDirector.size() + 1);
    }

    Employee hire(Employee employee) {
        personalOnDirector.add(employee);
        return employee;
    }


    @Override
    public String toString() {
        return "DirectorEmployeeImpl\t{" +
                "firstName = '" + super.getFirstName() + '\'' +
                ", secondName = '" + super.getSecondName() + '\'' +
                ", salary = '" + salary() + '\'' +
                "}\n" + personalOnDirector;
    }

    public List<Employee> getPersonalOnDirector() {
        return personalOnDirector;
    }
}
