package org.example.template;

import java.util.Date;

class AdminSaveService extends SaveService {
    @Override
    protected boolean birthdayNeeded(Date birthday) {
        return false;
    }

    @Override
    protected void saveUser(User user) {
        System.out.println("Save to BD, it is Admin");
    }
}
