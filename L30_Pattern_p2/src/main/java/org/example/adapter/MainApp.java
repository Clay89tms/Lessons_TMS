package org.example.adapter;

import java.util.Date;

class MainApp {
     public static void main(String[] args) {
         MainHandler handler = new MainHandler(new AdapterClientServiceImpl());
         handler.save("Roma","020289", null);
     }
}
