package org.example.template;

import java.util.Date;

class UserHandler {

    private SaveService service;

    public void saveUser(String login, String password, Date birthday, boolean isAdmin) {
        if (isAdmin) {
            service = new AdminSaveService();
        }else{
            service = new UserSaveService();
        }

        service.save(login,password,birthday);
    }
}
