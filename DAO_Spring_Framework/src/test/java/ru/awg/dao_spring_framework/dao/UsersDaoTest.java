package ru.awg.dao_spring_framework.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.awg.dao_spring_framework.entities.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/users-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/users-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UsersDaoTest {

    @Autowired
    private UsersDAO usersDAO;

    @Test
    public void testGetAllUsers(){
        List<User> userList = usersDAO.getAllUsers();
        Assert.assertEquals(userList.size(), 2);
    }

    @Test
    @Transactional
    @Rollback
    public void testAddUser(){
        User jon = new User();
        jon.setFirstName("Jon");
        jon.setLastName("Jonson");

        Assert.assertTrue(usersDAO.addUser(jon));
    }
}