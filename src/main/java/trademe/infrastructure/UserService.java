package trademe.infrastructure;

import trademe.domain.User;

import java.util.Objects;

public final class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
    }

    public boolean isTheUserAlreadyLoggedIn(User user) {
        return user.getToken() != null;
    }

    public boolean isTheEmailAddressAvailable(String mail) {
        boolean isAvailable = true;
        for (User user : userRepository.getAllUsers()) {
            if (user.getUserMail().getValue().equals(mail)) {
                isAvailable = false;
                break;
            }
        }
        return isAvailable;
    }

    /*public void applyForMembership(User user) throws UnexpectedException {
        boolean isSuccessfullyRegistered = userRepository.register(user);
        if(!isSuccessfullyRegistered) {
            throw new IllegalStateException("Membership is not possible, maybe the email address is already assigned");
        }

        boolean isSuccessfullyLogged = this.userRepository.login(user.getUserMail().getValue(), user.getPassword().getValue());
        if(!isSuccessfullyLogged) {
            throw new UnexpectedException("Login has failed. Please try again");
        }

        this.userRepository.processPayment(user);
    }

    public boolean login(String email, String password) {
        return userRepository.login(email, password);
    }

    public void logout(User user) {
        userRepository.logout(user);
    }*/
}
