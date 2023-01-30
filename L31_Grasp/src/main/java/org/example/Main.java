package org.example;

public class Main {
    public static void main(String[] args) {
        DirectorEmployeeImpl director1 = new DirectorEmployeeImpl("Petr", "Petrov", 5, Position.DIRECTOR);
        WorkerEmployeeImpl hire = director1.hire("aa", "bb", 1, Position.WORKER);
        Employee wor2 = director1.hire("aa", "bb", 1, Position.WORKER);
        System.out.println("Salary " + director1.getFirstName() + " " + director1.getSecondName() + " = " + director1.salary(1500));
        Employee worker11 = director1.hire("Ivan1", "Ivanov1", 2, Position.WORKER);
        System.out.println("Salary " + worker11.getFirstName() + " " + worker11.getSecondName() + " = " + worker11.salary(900));
        worker11.hire("a", "b", 1, Position.WORKER);
        WorkerEmployeeImpl worker12 = new WorkerEmployeeImpl("Ivan2", "Ivanov2", 3, Position.WORKER);

    }
}