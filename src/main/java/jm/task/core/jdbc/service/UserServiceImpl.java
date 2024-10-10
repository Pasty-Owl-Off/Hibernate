package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao newUser = new UserDaoJDBCImpl();

    public void createUsersTable() {
        newUser.createUsersTable();
    }

    public void dropUsersTable() {
        newUser.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        newUser.saveUser(name, lastName, age);
        System.out.println("User с именем — " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        newUser.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return newUser.getAllUsers();
    }

    public void cleanUsersTable() {
        newUser.cleanUsersTable();
    }
}
