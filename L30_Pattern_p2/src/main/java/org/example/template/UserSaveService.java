package org.example.template;

import java.util.Date;

class UserSaveService extends SaveService {

    @Override
    protected boolean birthdayNeeded(Date birthday) {
        return birthday == null;
    }

    @Override
    protected void saveUser(User user) {
        System.out.println("Save to cache, if is user");
    }
}
