package org.example.decorator;

class MainApp {
    public static void main(String[] args) {

        ReadService readService = new LogReadServiceImpl(new BufferedReadServiceImpl(new SimpleReadServiceImpl()));

        for (int i = 0; i < 25; i++) {
            System.out.println(readService.read());
        }
    }
}
