package org.example.adapter;

import java.util.Date;

 class AdapterClientServiceImpl implements ClientService {

    UserService userService = new UserServiceImpl();


    @Override
    public void save(String login, String password, Date birthday) {
        var user = new User(login,password,birthday);
        userService.save(user);
    }
}
