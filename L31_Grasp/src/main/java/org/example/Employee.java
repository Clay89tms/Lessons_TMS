package org.example;

abstract class Employee {

    Employee employee;
    private String firstName;
    private String secondName;
    private Integer experience;
    private Position position;

    public Employee(String firstName, String secondName, Integer experience, Position position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.experience = experience;
        this.position = position;
    }

    Double salary(Integer baseRate) {
        return baseRate * this.position.koef * this.experience;
    }


    private Employee hire(String firstName, String secondName, Integer experience, Position position) {
        return hire(firstName, secondName, experience, position);
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
}
