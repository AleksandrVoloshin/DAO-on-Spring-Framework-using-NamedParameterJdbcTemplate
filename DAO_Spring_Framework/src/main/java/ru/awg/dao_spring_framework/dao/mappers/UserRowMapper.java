package ru.awg.dao_spring_framework.dao.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.awg.dao_spring_framework.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        final User user = new User();

        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("firstname"));
        user.setLastName(resultSet.getString("lastname"));

        return user;
    }
}