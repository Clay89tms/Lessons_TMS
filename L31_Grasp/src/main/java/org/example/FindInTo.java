package org.example;

import java.util.List;

public class FindInTo {

    public static boolean find(DirectorEmployeeImpl employee, String name) {
        boolean select = false;

        if (!employee.getPersonalOnDirector().isEmpty()) {
            List<Employee> personalOnDirector1 = employee.getPersonalOnDirector();

            for (int counter = 0; counter < personalOnDirector1.size(); counter++) {
                System.out.print(name + " ?= " + personalOnDirector1.get(counter).getFirstName());
                if (name.equals(personalOnDirector1.get(counter).getFirstName())) {
                    select = true;
                    break;
                } else {
                    System.out.println("\t(NO)");
                    if (personalOnDirector1.get(counter).getPosition() == Position.DIRECTOR) {
                        select = find((DirectorEmployeeImpl) personalOnDirector1.get(counter), name);
                    }
                }
            }
        }
        return select;
    }
}