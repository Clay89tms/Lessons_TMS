package org.example;

public class UserDBServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save to DB");
    }
}
