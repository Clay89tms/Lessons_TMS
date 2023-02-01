package org.example;

import java.util.ArrayList;
import java.util.List;

public class DirectorEmployeeImpl extends Employee {

    static final List<Employee> personalOnDirector = new ArrayList<>();

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

    public String str(List personalOnDirector) {
        String strstr = "";
        for (int i = 0; i < personalOnDirector.size(); i++) {
            strstr += personalOnDirector.get(i).toString();
        }
        return strstr;
    }

    Employee hire(Employee employee) {
        personalOnDirector.add(employee);
        return employee;
    }

    String personalList() {
        String personalList = "";
        for (int i = 0; i < personalOnDirector.size(); i++) {
            personalList += "\n" + personalOnDirector.toString();
        }
        return personalList;
    }

    @Override
    public String toString() {
        return "DirectorEmployeeImpl\t{" +
                "firstName = '" + super.getFirstName() + '\'' +
                ", secondName = '" + super.getSecondName() + '\'' +
                '}';
    }
}
