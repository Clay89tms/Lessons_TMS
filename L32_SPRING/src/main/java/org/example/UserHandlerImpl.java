package org.example;

import java.util.List;

public class UserHandlerImpl implements UserHandler {

    private List<UserService> service;
    private List<Messenger> messenger;

    public UserHandlerImpl() {
    }

    //    public UserHandlerImpl(UserService service, Messenger messenger) {
////        System.out.println("constructor " + text);
//        this.service = service;
//        this.messenger = messenger;
//    }

    public List<UserService> getService() {
        return service;
    }
    public void setService(List<UserService> service) {
        this.service = service;
    }
    public List<Messenger> getMessenger() {
        return messenger;
    }
    public void setMessenger(List<Messenger> messenger) {
        this.messenger = messenger;
    }



    public void setup() {
        System.out.println("init user ser, create IO connections");
    }

    @Override
    public void saveUser() {
        service.forEach(userService -> userService.save());
        messenger.forEach(messenger1 -> messenger1.sendMessage("~hi~"));
    }

    public void cleanCache() {
        System.out.println("clean Cache");
    }
}
