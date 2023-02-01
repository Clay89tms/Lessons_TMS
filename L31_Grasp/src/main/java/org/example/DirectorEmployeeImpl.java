package org.example;

import java.util.ArrayList;
import java.util.List;

public class DirectorEmployeeImpl extends Employee {
    private Double salary = salary();
    private String list = "";

    static final List<Employee> personalOnDirector = new ArrayList<>();


    public DirectorEmployeeImpl(String firstName, String secondName, Integer experience) {
        super(firstName, secondName, experience, Position.DIRECTOR);
    }

    @Override
    public Double salary() {
        return super.salary() * getPersonalSize();
    }

    Employee hire(Employee employee) {
        personalOnDirector.add(employee);
        this.salary = salary();
        return employee;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getPersonalSize() {
        Double size = (double) personalOnDirector.size();
        if (size == 0) {
            return 1.0;
        } else {
            return size;
        }
    }

//    private String getPersonalList() {
//        String list = null;
//        if (personalOnDirector.size() > 0) {
//            System.out.println("\n\tPersonal : ");
//            for (int i = 0; i < personalOnDirector.size(); i++) {
//                list += ("\n\t" + (i+1) + ") " + personalOnDirector.get(i));
//            }
//        }
//        return list;
//    }

    @Override
    public String toString() {
        String list = "";
        if (personalOnDirector.size() > 0) {
           list = "\n\tPersonal : ";
            for (int i = 0; i < personalOnDirector.size(); i++) {
                list += ("\n\t" + (i + 1) + ") " + personalOnDirector.get(i));
            }
        }
        return "DirectorEmployeeImpl\t{" +
                "firstName = '" + super.getFirstName() + '\'' +
                ", secondName = '" + super.getSecondName() + '\'' +
                ", salary = " + salary +
                '}' + list;
    }
}
