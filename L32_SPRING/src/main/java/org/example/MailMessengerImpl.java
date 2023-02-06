package org.example;

public class MailMessengerImpl implements Messenger {

    public MailMessengerImpl() {
        System.out.println("create email.");
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("send to Email next line: " + text);
    }
}
