package ru.awg.dao_spring_framework.dao;

import ru.awg.dao_spring_framework.entities.User;

import java.util.List;

public interface UsersDAO {

    List<User> getAllUsers();

    boolean addUser(User user);
}