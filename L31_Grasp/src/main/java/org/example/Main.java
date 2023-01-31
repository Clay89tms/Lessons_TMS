package org.example;

public class Main {
    public static void main(String[] args) {
        DirectorEmployeeImpl director1 = new DirectorEmployeeImpl("Petr", "Petrov", 5);
        Employee worker1 = new WorkerEmployeeImpl("Ivan1", "Ivanov1", 2);
        director1.hire(worker1);
        director1.hire(worker1);
        director1.hire(worker1);
        System.out.println(director1);
        System.out.println(worker1);
        System.out.println(director1.getSalary());



//        worker1.hire(worker1);
        System.out.println(director1);
//
//        Employee worker01 = director1.hire("aa", "bb", 1, Position.WORKER);
//        System.out.println(worker01);
//        System.out.println(director1);
//
//        Employee worker02 = director1.hire("Ivan1", "Ivanov1", 2, Position.WORKER);
//        System.out.println(director1);
//        Employee worker03 = director1.hire("Ivan1", "Ivanov1", 2, Position.WORKER);
//        System.out.println(director1);
//        Employee worker04 = director1.hire("Ivan1", "Ivanov1", 2, Position.WORKER);
//        System.out.println(director1);
//
//
//        System.out.println();
//        Employee wor2 = director1.hire("aa", "bb", 1, Position.WORKER);
//
//        Employee worker11 = director1.hire("Ivan1", "Ivanov1", 2, Position.WORKER);
//
//        worker11.hire("a", "b", 1, Position.WORKER);
//        WorkerEmployeeImpl worker12 = new WorkerEmployeeImpl("Ivan2", "Ivanov2", 3, Position.WORKER);

    }
}