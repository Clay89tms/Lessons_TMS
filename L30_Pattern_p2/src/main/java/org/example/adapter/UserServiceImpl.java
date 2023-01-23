package org.example.adapter;

 class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        System.out.println("save to DB");
    }
}
