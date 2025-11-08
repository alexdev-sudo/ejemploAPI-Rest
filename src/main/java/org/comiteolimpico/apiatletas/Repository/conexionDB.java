package org.comiteolimpico.apiatletas.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/atletas";
    private static final String USER = "ezequielumg";
    private static final String PASS = "UMG*123";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);

    }

}
