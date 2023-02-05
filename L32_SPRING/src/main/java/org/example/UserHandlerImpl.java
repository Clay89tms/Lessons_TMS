package org.example;

public class UserHandlerImpl implements UserHandler {

    private UserService service;
    private Messenger messenger;


    public UserHandlerImpl(UserService service, Messenger messenger, String text) {
        System.out.println("constructor " + text);
        this.service = service;
        this.messenger = messenger;
    }

    public void setup(){
        System.out.println("init user ser, create IO connections");
    }

    @Override
    public void saveUser() {
        service.save();
        messenger.sendMessage("saved");
    }

    public void cleanCache(){
        System.out.println("clean Cache");
    }
}
