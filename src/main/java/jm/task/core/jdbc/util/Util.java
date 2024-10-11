package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String CON_URL = "jdbc:mysql://localhost:3306/usersdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Root12345";
    private static final String DIALECT = "org.hibernate.dialect.MySQL8Dialect";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

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
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(Environment.URL, CON_URL);
        hibernateProperties.put(Environment.DRIVER, DRIVER);
        hibernateProperties.put(Environment.USER, USERNAME);
        hibernateProperties.put(Environment.PASS, PASSWORD);
        hibernateProperties.put(Environment.DIALECT, DIALECT);
        hibernateProperties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        hibernateProperties.put(Environment.HBM2DDL_AUTO, "none");

        Configuration hibernateConfig = new Configuration()
                .setProperties(hibernateProperties)
                .addAnnotatedClass(User.class);
        SessionFactory factory = hibernateConfig.buildSessionFactory();

        return factory;
    }
}
