package com.springexample.common.constraits;

import com.springexample.common.model.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabasePasswordSecurerBean extends JdbcDaoSupport {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void secureDatabase() {
        getJdbcTemplate().query("select username, password from users",
                new RowCallbackHandler(){
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        String username = rs.getString(1);
                        String password = rs.getString(2);
                        String encodedPassword =
                                passwordEncoder.encodePassword(password, username);
                        getJdbcTemplate().update("update users set password = ? where username = ?", encodedPassword, username);
                        System.out.println("Updating password for username:"+username+" to: "+encodedPassword);
                        logger.debug("Updating password for username:" + username + " to: " + encodedPassword);
                    }
                });
    }

    //Test Secure password method for new user
    public  String secureUser(User user) {
        String encodedPassword = passwordEncoder.encodePassword(user.getPassword(), user.getUsername());
        return encodedPassword;
    }
}
