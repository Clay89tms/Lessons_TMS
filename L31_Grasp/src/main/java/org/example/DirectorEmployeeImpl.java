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
        if (personalOnDirector.size() == 0) {
            return super.salary();
        } else {
            return super.salary() * personalOnDirector.size();
        }
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
}
