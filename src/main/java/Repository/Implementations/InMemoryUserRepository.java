package Repository.Implementations;

import Factory.TokenFactory;
import Model.User;
import Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public final class InMemoryUserRepository implements UserRepository {

    private final List<User> registeredUsers = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return this.registeredUsers;
    }

    @Override
    public boolean register(User user) {
        if (!this.isTheEmailAddressAvailable(user.getUserMail().getValue())) {
            return false;
        }
        return this.registeredUsers.add(user);
    }

    @Override
    public boolean login(String email, String password) {
        User user = this.searchUserByMailAndPassword(email, password);

        if (user == null) {
            return false;
        }

        if (!isTheUserAlreadyLoggedIn(user)) {
            user.setToken(TokenFactory.generateToken());
        }

        return isTheUserAlreadyLoggedIn(user);
    }

    @Override
    public void logout(User user) {
        user.setToken(null);
    }

    @Override
    public void processPayment(User user) {
        //throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public boolean isTheUserAlreadyLoggedIn(User user) {
        return user.getToken() != null;
    }

    @Override
    public boolean isTheEmailAddressAvailable(String mail) {
        boolean isAvailable = true;
        for (User registeredUser : registeredUsers) {
            if (registeredUser.getUserMail().getValue().equals(mail)) {
                isAvailable = false;
                break;
            }
        }
        return isAvailable;
    }

    @Override
    public User searchUserByMailAndPassword(String email, String password) {
        User foundUser = null;
        for (User registeredUser : registeredUsers) {
            if (registeredUser.getUserMail().getValue().equals(email) && registeredUser.getPassword().getValue().equals(password)) {
                foundUser = registeredUser;
            }
        }
        return foundUser;
    }
}
