package org.example;

public class MailMessengerImpl implements Messenger {

    public MailMessengerImpl() {
        System.out.println("mail const");
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("send to Email next line: " + text);
    }
}
