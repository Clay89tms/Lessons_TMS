package org.example;

abstract class Employee {

    private String firstName;
    private String secondName;
    private Integer experience;
    private Position position;

    private static final Integer baseRate = 900;

    public Employee(String firstName, String secondName, Integer experience, Position position) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.experience = experience;
        this.position = position;
    }

    public Double salary() {
        Double salary = position.koef * baseRate * experience;
        return salary;
    }

    public Integer getBaseRate() {
        return baseRate;
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


    public Integer getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee\t{" +
                "firstName = '" + firstName + '\'' +
                ", secondName = '" + secondName + '\'' +
                ", salary = '" + salary() + '\'' +
                '}';
    }

}
