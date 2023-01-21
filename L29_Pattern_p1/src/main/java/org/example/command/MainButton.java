package org.example.command;

class MainButton {
    public static void main(String[] args) {

        Button button = new CopyButtonImpl();
        ButtonService service = new ButtonService();
        service.doButton(button);

    }
}
