package by.tms.storage;

import by.tms.model.Role;
import by.tms.model.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private static List<User> users = new ArrayList<>();
    static int userId = 1;

    static {
        users.add(new User("Admin", "admin", "admin", Role.ADMIN));
    }

    public void save(User user){
        user.setId(userId);
        users.add(user);
        userId++;
    }

    public boolean contains(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRegistered(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    public static List<User> getUsers() {
        return users;
    }
}
