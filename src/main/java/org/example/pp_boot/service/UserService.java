package org.example.pp_boot.service;


import org.example.pp_boot.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(long id);

    public void deleteUser(long id);

    void addUser(User user);

    void removeUser(long id);

    User getUserById(long id);
}
