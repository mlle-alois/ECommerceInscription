package Repository;

import Model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    boolean register(User user);

    boolean login(String email, String password);

    void logout(User user);

    void processPayment(User user);

    boolean isTheUserAlreadyLoggedIn(User user);

    boolean isTheEmailAddressAvailable(String mail);

    User searchUserByMailAndPassword(String email, String password);
}
