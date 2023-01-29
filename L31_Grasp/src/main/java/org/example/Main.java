package org.example;

public class Main {
    public static void main(String[] args) {
        Employee director1 = new DirectorEmployeeImpl("Petr", "Petrov", 5, Position.DIRECTOR);
        Employee worker11 = new WorkerEmployeeImpl("Ivan1", "Ivanov1", 2, Position.WORKER);
        WorkerEmployeeImpl worker12 = new WorkerEmployeeImpl("Ivan2", "Ivanov2", 3, Position.WORKER);
    }
}