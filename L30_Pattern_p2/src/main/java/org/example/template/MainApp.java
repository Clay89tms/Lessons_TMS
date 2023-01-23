package org.example.template;

import java.util.Date;

class MainApp {
    public static void main(String[] args) {
        UserHandler handler = new UserHandler();
        handler.saveUser("Roma", "888", new Date(), true);
    }
}
