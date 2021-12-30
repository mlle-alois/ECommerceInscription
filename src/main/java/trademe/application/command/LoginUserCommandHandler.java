package trademe.application.command;

import trademe.domain.User;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.TokenFactory;
import trademe.infrastructure.UserRepository;
import trademe.infrastructure.UserService;
import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;

import java.util.Objects;

public final class LoginUserCommandHandler implements CommandHandler<LoginUser, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final UserService userService;

    public LoginUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher, UserService userService) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.eventEventDispatcher = Objects.requireNonNull(eventEventDispatcher);
        this.userService = Objects.requireNonNull(userService);
    }

    public UserId handle(LoginUser loginUser){
        User user = userRepository.findByEmailAndPassword(loginUser.userMail, loginUser.password);
        if (!userService.isTheUserAlreadyLoggedIn(user)) {
            user.setToken(TokenFactory.generateToken());
        }
        //TODO vérification succès connexion ?
        eventEventDispatcher.dispatch(new LoginUserEvent(user.getId()));
        return user.getId();
    }
}
