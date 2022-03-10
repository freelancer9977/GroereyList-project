package repo;

import models.User;

public interface UserDAO {
    User getUserGivenUsername(String username);
    void createUser(User user);
}
