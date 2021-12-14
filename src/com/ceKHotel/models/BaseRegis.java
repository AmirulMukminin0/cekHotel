package com.ceKHotel.models;

import java.sql.SQLException;

public abstract class BaseRegis extends BaseModel{
    BaseRegis() throws SQLException {
        super();
    }

    public abstract void registrasiCs() throws SQLException;
}
