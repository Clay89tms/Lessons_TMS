package org.example;

public class UserDBServiceImpl implements UserService {

    public UserDBServiceImpl() {
        System.out.println("DB const");
    }

    @Override
    public void save() {
        System.out.println("save to DB");
    }
}
