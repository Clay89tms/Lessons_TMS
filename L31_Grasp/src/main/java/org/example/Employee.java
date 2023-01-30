package org.example;

import lombok.ToString;


abstract class Employee {

    private Employee employee;

    private String firstName;
    private String secondName;
    private Integer experience;
    private Position position;
    private Double salary;

    public Employee(String firstName, String secondName, Integer experience, Position position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.experience = experience;
        this.position = position;
        this.salary = salary(900);
    }

    Double salary(Integer baseRate) {
        return salary;
    }


    Employee hire(String firstName, String secondName, Integer experience, Position position) {
        if(position == Position.DIRECTOR) {
            employee = new DirectorEmployeeImpl(firstName, secondName, experience, position);
        } else if (position == Position.WORKER){
            employee = new WorkerEmployeeImpl(firstName, secondName, experience, position);
            DirectorEmployeeImpl.personalOnDirector.add(employee);
        }
        return employee;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Position getPosition() {
        return position;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Integer getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName = '" + firstName + '\'' +
                ", secondName = '" + secondName + '\'' +
                ", salary = " + salary +
                '}';
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
