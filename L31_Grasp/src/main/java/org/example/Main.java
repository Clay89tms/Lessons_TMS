package org.example;

public class Main {
    public static void main(String[] args) {
//1)Создаем Директора1, Работника1, Работника2.
        System.out.println("1)");
        DirectorEmployeeImpl director1 = new DirectorEmployeeImpl("Director", "Directorov", 5);
        System.out.println(director1 + "\n");
        WorkerEmployeeImpl worker11 = new WorkerEmployeeImpl("Ivan1", "Ivanov1", 2);
        System.out.println(worker11 + "\n");
        WorkerEmployeeImpl worker12 = new WorkerEmployeeImpl("Sasha1", "Sashow1", 4);
        System.out.println(worker12 + "\n");

//2)Закрепляем Р1 и Р2 за Д1
        System.out.println("2)");
        director1.hire(worker11);
        director1.hire(worker12);
        System.out.println(director1 + "\n");

//3)Создаем Д2, Р3, и закрепляем Р3 за Д2
        System.out.println("3)");
        DirectorEmployeeImpl director2 = new DirectorEmployeeImpl("Petr", "Petrov", 2);
        System.out.println(director2 + "\n");
        WorkerEmployeeImpl worker21 = new WorkerEmployeeImpl("Max", "Maiximov", 3);
        System.out.println(worker21);
        director2.hire(worker21);
        System.out.println(director2 + "\n");

        director1.hire(director2);

//4)Проверяем цепочку подчиненных
        System.out.println("4)");
        System.out.println(director1 + "\n");

//5)
        if(director1.findInTo(director1, "Max")){
            System.out.println("est");
        }
    }
}