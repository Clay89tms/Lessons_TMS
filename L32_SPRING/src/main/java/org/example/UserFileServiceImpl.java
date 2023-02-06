package org.example;

public class UserFileServiceImpl implements UserService {

    public UserFileServiceImpl() {
        System.out.println("create user file");
    }

    @Override
    public void save() {
        System.out.println("save to file");
    }
}
