package org.example;

abstract class Employee {
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

    public Double salary(Integer baseRate){
        return baseRate*position.koef*experience;
    }

}
