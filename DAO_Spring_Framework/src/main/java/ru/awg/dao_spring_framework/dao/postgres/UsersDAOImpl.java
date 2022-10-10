package ru.awg.dao_spring_framework.dao.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.awg.dao_spring_framework.dao.UsersDAO;
import ru.awg.dao_spring_framework.dao.mappers.UserRowMapper;
import ru.awg.dao_spring_framework.entities.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsersDAOImpl implements UsersDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SQL_GET_ALL_USERS = "SELECT * FROM users;";
    private final static String SQL_ADD_USERS = "INSERT INTO users (firstname, lastname) VALUES(:firstname, :lastname);";

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAllUsers() {
        UserRowMapper mapper = new UserRowMapper();
        try {
            return namedParameterJdbcTemplate.query(SQL_GET_ALL_USERS, mapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public boolean addUser(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstname", user.getFirstName());
        params.put("lastname", user.getLastName());

        return namedParameterJdbcTemplate.update(SQL_ADD_USERS, params) > 0;
    }
}