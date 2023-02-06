package org.example;

public class TelegramMessengerImpl implements Messenger {

    public TelegramMessengerImpl() {
        System.out.println("create telegram.");
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("send to telegram next line: " + text);
    }
}
