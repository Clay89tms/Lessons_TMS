package org.example;

import java.util.List;

public class FindInTo {

    public static boolean find(DirectorEmployeeImpl employee, String name) {
        boolean select = false;
        if (!employee.getPersonalOnDirector().isEmpty()) {
            List<Employee> personalOnDirector1 = employee.getPersonalOnDirector();
            for (int counter = 0; counter < personalOnDirector1.size(); counter++) {
                if (personalOnDirector1.get(counter).getPosition() == Position.DIRECTOR) {
                    DirectorEmployeeImpl directorInTo = (DirectorEmployeeImpl) personalOnDirector1.get(counter);
                    if (!directorInTo.getPersonalOnDirector().isEmpty()) {
                        find(directorInTo, name);
                    }
                } else {
                    System.out.print(name + " ?= " + personalOnDirector1.get(counter).getFirstName());
                    if (name.equals(personalOnDirector1.get(counter).getFirstName())) {
                        select = true;
                        return select;
                    } else {
                        System.out.println("\t(NO)");
                    }
                }
            }
        }
        return select;
    }
}