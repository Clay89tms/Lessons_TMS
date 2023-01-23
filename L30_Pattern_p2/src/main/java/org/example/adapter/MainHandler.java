package org.example.adapter;

import java.util.Date;

class MainHandler {
    ClientService service;

    public MainHandler(ClientService service) {
        this.service = service;
    }

    void save(String login, String password, Date birthday) {
        service.save(login, password, birthday);
    }
}
