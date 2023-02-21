package org.example.factory_method;

public class MainCarRepairFactory {
    public static void main(String[] args) {
        CarRepairFactory factory = new CarRepairFactory();
        STO_Garaje stoGaraje = factory.create();

        RepairService repairService = new RepairService();
        CarRepairFactoryImpl carRepairFactory = new CarRepairFactoryImpl();
        repairService.repair(carRepairFactory);

        System.out.println();
    }
}
