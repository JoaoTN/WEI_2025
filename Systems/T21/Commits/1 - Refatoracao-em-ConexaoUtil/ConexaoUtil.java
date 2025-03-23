package br.sistema.crud.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class DatabaseConnection {
    private static final String MYSQL_DRIVER_KEY = "br.edu.devmedia.drive.mysql";
    private static final String CONNECTION_URL_KEY = "br.edu.devmedia.url.conexao";
    private static final String USERNAME_KEY = "br.edu.devmedia.bd.usuario";
    private static final String PASSWORD_KEY = "br.edu.devmedia.bd.senha";

    private static ResourceBundle config;

    static {
        config = ResourceBundle.getBundle("config");
    }

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        loadDriver();
        return DriverManager.getConnection(getConnectionURL(), getUsername(), getPassword());
    }

    private static void loadDriver() throws ClassNotFoundException {
        Class.forName(config.getString(MYSQL_DRIVER_KEY));
    }

    private static String getConnectionURL() {
        return config.getString(CONNECTION_URL_KEY);
    }

    private static String getUsername() {
        return config.getString(USERNAME_KEY);
    }

    private static String getPassword() {
        return config.getString(PASSWORD_KEY);
    }
}
