import Model.Password;
import Model.User;
import Model.UserMail;
import Repository.Implementations.InMemoryUserRepository;
import Repository.UserRepository;
import Service.UserService;

import java.rmi.UnexpectedException;

public final class Main {
    public static void main(String[] args) throws UnexpectedException {
        UserRepository inMemoryUserRepository = new InMemoryUserRepository();
        UserService userService = new UserService(inMemoryUserRepository);

        User user1 = User.createWithoutToken(UserMail.of("mail@mail.fr"), "User 1", "bobi", Password.of("secret"));
        User user2 = User.createWithoutToken(UserMail.of("mail2@mail.fr"), "User 2", "jonny", Password.of("very secret"));
        User user3 = User.createWithoutToken(UserMail.of("mail@mail.fr"), "User 3", "lola", Password.of("root"));

        userService.applyForMembership(user1);
        userService.applyForMembership(user2);

        userService.applyForMembership(user3);
    }
}
