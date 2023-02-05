package org.example;

public class TelegramMessengerImpl implements Messenger {
    @Override
    public void sendMessage(String text) {
        System.out.println("send to telegram next line: " + text);
    }
}
