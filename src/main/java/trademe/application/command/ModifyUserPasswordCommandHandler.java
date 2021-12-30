package trademe.application.command;

import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.infrastructure.UserRepository;

import java.util.Objects;

public final class ModifyUserPasswordCommandHandler implements CommandHandler<ModifyUserPassword, Void> {

    private final UserRepository userRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public ModifyUserPasswordCommandHandler(UserRepository userRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.eventEventDispatcher = Objects.requireNonNull(eventEventDispatcher);
    }

    @Override
    public Void handle(ModifyUserPassword command) {
        var userId = UserId.of(command.userId);
        var user = userRepository.findById(userId);
        var password = Password.of(command.password.password);
        user.changePassword(password);
        userRepository.add(user);
        eventEventDispatcher.dispatch(new ModifyUserPasswordEvent(userId));
        return null;
    }
}
