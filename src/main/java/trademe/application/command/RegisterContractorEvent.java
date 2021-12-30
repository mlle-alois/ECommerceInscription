package trademe.application.command;

import trademe.kernel.ApplicationEvent;
import trademe.domain.valueObjects.UserId;

import java.util.Objects;

public final class RegisterContractorEvent implements ApplicationEvent {
    private final UserId userId;

    public RegisterContractorEvent(UserId userId) {
        this.userId = Objects.requireNonNull(userId);
    }
}
