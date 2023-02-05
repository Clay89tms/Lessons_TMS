package org.example;

public class MailMessengerImpl implements Messenger {
    @Override
    public void sendMessage(String text) {
        System.out.println("send to Email next line: " + text);
    }
}
