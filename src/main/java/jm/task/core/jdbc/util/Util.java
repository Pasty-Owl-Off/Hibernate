package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String CON_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Root12345";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(CON_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Не удалось установить соединение");
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return factory;
    }
}
