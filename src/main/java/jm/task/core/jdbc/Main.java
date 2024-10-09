package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDAO = new UserDaoJDBCImpl();
        userDAO.createUsersTable();

        userDAO.saveUser("Андрей", "Шишмаков", (byte) 18);
        System.out.println("User с именем — Андрей добавлен в базу данных");
        userDAO.saveUser("Илья", "Фатьянов", (byte) 22);
        System.out.println("User с именем — Илья добавлен в базу данных");
        userDAO.saveUser("Анастасия", "Мурадян", (byte) 25);
        System.out.println("User с именем — Анастасия добавлен в базу данных");
        userDAO.saveUser("Виктория", "Федорченко", (byte) 17);
        System.out.println("User с именем — Виктория добавлен в базу данных");

        userDAO.getAllUsers().stream().forEach(System.out::println);
        userDAO.cleanUsersTable();
        userDAO.dropUsersTable();
    }
}
