package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Андрей", "Шишмаков", (byte) 18);
        userService.saveUser("Илья", "Фатьянов", (byte) 22);
        userService.saveUser("Анастасия", "Мурадян", (byte) 25);
        userService.saveUser("Виктория", "Федорченко", (byte) 17);

        userService.getAllUsers().stream().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
