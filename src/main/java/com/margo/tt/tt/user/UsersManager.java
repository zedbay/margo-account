package com.margo.tt.tt.user;
import java.util.ArrayList;
import java.util.Arrays;

public class UsersManager {

    private static final UsersManager INSTANCE = new UsersManager(new User[]{new User(), new User(), new User()});

    public static UsersManager getInstance() {
        return UsersManager.INSTANCE;
    }

    private final ArrayList<User> users = new ArrayList<>();

    private UsersManager(User[] users) {
        this.users.addAll(Arrays.asList(users));
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public User findUser(Integer userId) throws UnknownUserException {
        User userToFind = this.users.stream()
                .filter(user -> user.getId().equals(userId))
                .findAny()
                .orElse(null);
        if (userToFind == null) {
            throw new UnknownUserException("Unknown user");
        }
        return userToFind;
    }


}
