package org.example;

public class Main {
    public static void main(String[] args) {
        DirectorEmployeeImpl director1 = new DirectorEmployeeImpl("Director", "Directorov", 5);
        System.out.println(director1 + "\nsalary = " + director1.salary());
        WorkerEmployeeImpl worker11 = new WorkerEmployeeImpl("Ivan1", "Ivanov1", 2);
        System.out.println(worker11 + "\nsalary = " + worker11.salary());
        WorkerEmployeeImpl worker12 = new WorkerEmployeeImpl("Sasha1", "Sashow1", 4);
        System.out.println(worker12 + "\nsalary = " + worker12.salary());
        DirectorEmployeeImpl director2 = new DirectorEmployeeImpl("Petr", "Petrov", 2);
        System.out.println(director2 + "\nsalary = " + director2.salary());

        director1.hire(worker11);
        System.out.println(director1 + "\nsalary = " + director1.salary());
        System.out.println(director1.personalList());
        director1.hire(worker12);
        System.out.println(director1 + "\nsalary = " + director1.salary());
        director1.hire(director2);
        System.out.println(director1  + "\nsalary = " + director1.salary());
        director1.hire(worker11);
        WorkerEmployeeImpl worker21 = new WorkerEmployeeImpl("Max", "Maiximov", 3);
        System.out.println(worker21);
//
        director2.hire(worker21);






    }
}