package trademe.application.command;

import trademe.kernel.ApplicationEvent;
import trademe.domain.valueObjects.UserId;

import java.util.Objects;

public final class LogoutUserEvent implements ApplicationEvent {
    private final UserId userId;

    public LogoutUserEvent(UserId userId) {
        this.userId = Objects.requireNonNull(userId);
    }

    public UserId getUserId() {
        return userId;
    }
}
