package trademe.application.command;

import trademe.kernel.Command;
import trademe.domain.valueObjects.UserId;

import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class LogoutUser implements Command {

    public final UserId userId;

    public LogoutUser(UserId userId) {
        this.userId = Objects.requireNonNull(userId);
    }
}
