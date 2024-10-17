package com.example.dao;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository  // Marks this class as a Spring bean for data access
public class UserDaoImpl implements UserDao {

    @Autowired  // Automatically injects JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        jdbcTemplate.update(query, user.getName(), user.getEmail());
    }

    @Override
    public User findById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new UserRowMapper());
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM users";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getId());
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    // RowMapper to map the result set to a User object
    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }
}
