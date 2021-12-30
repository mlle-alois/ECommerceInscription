package trademe.application.command;

import trademe.kernel.ApplicationEvent;
import trademe.domain.valueObjects.UserId;

import java.util.Objects;

public final class ModifyUserPasswordEvent implements ApplicationEvent {
    private final UserId userId;

    public ModifyUserPasswordEvent(UserId userId) {
        this.userId = Objects.requireNonNull(userId);
    }
}
