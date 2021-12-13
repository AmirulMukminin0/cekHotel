package com.ceKHotel.models;

import java.sql.SQLException;

public interface Login {
    static void Login(String username, String password) throws SQLException {
    }
    void loginCs() throws SQLException;
}
