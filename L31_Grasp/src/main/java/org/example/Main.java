package org.example;

public class Main {
    public static void main(String[] args) {
        DirectorEmployeeImpl director01 = new DirectorEmployeeImpl("Director", "Directorov", 5);
        System.out.println(director01);
        WorkerEmployeeImpl worker01 = new WorkerEmployeeImpl("Ivan1", "Ivanov1", 2);
        System.out.println(worker01);
        WorkerEmployeeImpl worker02 = new WorkerEmployeeImpl("Sasha1", "Sashow1", 4);
        System.out.println(worker02);
        DirectorEmployeeImpl director11 = new DirectorEmployeeImpl("Petr", "Petrov", 2);
        System.out.println(director11);
        director01.hire(director11);


        director01.hire(worker01);
        director01.hire(worker02);




    }
}