package org.tms.dz32;

import java.util.List;

public class PrintService {

    public PrintService() {

    }
    public static void question() {
        System.out.println("You have money: " + ControlService.getMoney());
        System.out.print("\nbet is = 10$; \nmake you're choice pair (1-3): ");
    }

}