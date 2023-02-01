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

    boolean findInTo(DirectorEmployeeImpl employee, String name) {
        boolean response = false;
        List<Employee> personalOnDirector1 = employee.getPersonalOnDirector();
        for (int i = 0; i < personalOnDirector1.size(); i++) {
            String find = personalOnDirector1.get(i).getFirstName();
            System.out.println(find);
            if (name.equals(find)){
                response = true;
            }
        }
        return response;
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
