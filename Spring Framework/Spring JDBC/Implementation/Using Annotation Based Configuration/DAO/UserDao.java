package com.example.dao;

import com.example.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);
    User findById(int id);
    List<User> findAll();
    void update(User user);
    void deleteById(int id);
}
