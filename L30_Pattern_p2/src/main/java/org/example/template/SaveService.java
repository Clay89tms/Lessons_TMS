package org.example.template;

import java.util.Date;

abstract class SaveService {

    public void save(String login, String password, Date birthday) {
        var user = new User(login, password, birthday);
        System.out.println("User was created");

        if(user.getLogin() == null || user.getPassword() == null || birthdayNeeded(user.getBirthday())){
            throw new RuntimeException("valid");
        }

        saveUser(user);
        System.out.println("user SAVED");
    }

    protected abstract boolean birthdayNeeded(Date birthday);
    protected abstract  void saveUser(User user);
}
