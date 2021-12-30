package trademe.application.command;

import trademe.domain.User;
import trademe.domain.valueObjects.UserId;
import trademe.infrastructure.UserRepository;
import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;

import java.util.Objects;

public final class LogoutUserCommandHandler implements CommandHandler<LogoutUser, UserId> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public LogoutUserCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.eventEventDispatcher = Objects.requireNonNull(eventEventDispatcher);
    }

    public UserId handle(LogoutUser loginUser){
        User user = userRepository.findById(loginUser.userId);
        user.setToken(null);
        eventEventDispatcher.dispatch(new LogoutUserEvent(user.getId()));
        return user.getId();
    }
}
