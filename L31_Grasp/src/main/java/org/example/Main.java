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

        DirectorEmployeeImpl director3 = new DirectorEmployeeImpl("dir3", "dirov3", 2);
        WorkerEmployeeImpl wor22 = new WorkerEmployeeImpl("wor22", "worov22", 3);

        director2.hire(wor22);
        director2.hire(director3);

//4)Проверяем цепочку подчиненных
        System.out.println("4)");
        System.out.println(director1 + "\n");

//5)Проверям подчиненных (ПОИСК В ГЛУБЬ)
        if (FindInTo.find(director1, "Ivan1")) {
            System.out.println("\t(YES)");
        }

//Дополнительная проверка
        DirectorEmployeeImpl dir1 = new DirectorEmployeeImpl("Dir1", "Dorov1", 5);
        DirectorEmployeeImpl dir2 = new DirectorEmployeeImpl("Dir2", "Dorov2", 5);
        DirectorEmployeeImpl dir3 = new DirectorEmployeeImpl("Dir3", "Dorov3", 5);

        WorkerEmployeeImpl wor1 = new WorkerEmployeeImpl("wor1", "worov1", 2);
        WorkerEmployeeImpl wor2 = new WorkerEmployeeImpl("wor2", "worov2", 2);
        WorkerEmployeeImpl wor3 = new WorkerEmployeeImpl("wor3", "worov3", 2);
        WorkerEmployeeImpl wor4 = new WorkerEmployeeImpl("wor4", "worov4", 2);

        dir2.hire(wor1);
        dir2.hire(wor2);
        dir3.hire(wor3);
        dir3.hire(wor4);

        dir1.hire(dir2);
        dir1.hire(dir3);

        if (FindInTo.find(dir1, "wor1")) {
            System.out.println("\t(YES)");
        }
    }
}