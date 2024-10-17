package com.example.dao;

import com.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    // Setter for JdbcTemplate (Spring will inject this)
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save user to database
    @Override
    public void save(User user) {
        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        jdbcTemplate.update(query, user.getName(), user.getEmail());
    }

    // Find user by ID
    @Override
    public User findById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, new UserRowMapper());
    }

    // Find all users
    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM users";
        return jdbcTemplate.query(query, new UserRowMapper());
    }

    // Update user
    @Override
    public void update(User user) {
        String query = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getId());
    }

    // Delete user by ID
    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    // RowMapper for User
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
