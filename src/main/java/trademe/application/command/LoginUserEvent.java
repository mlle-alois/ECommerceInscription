package trademe.application.command;

import trademe.kernel.ApplicationEvent;
import trademe.domain.valueObjects.UserId;

import java.util.Objects;

public final class LoginUserEvent implements ApplicationEvent {
    private final UserId userId;

    public LoginUserEvent(UserId userId) {
        this.userId = Objects.requireNonNull(userId);
    }

    public UserId getUserId() {
        return userId;
    }
}
