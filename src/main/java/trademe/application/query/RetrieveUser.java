package trademe.application.query;

import trademe.domain.valueObjects.UserId;
import trademe.kernel.Query;

import java.util.Objects;

public final class RetrieveUser implements Query {

    public final UserId userId;

    public RetrieveUser(UserId userId) {
        this.userId = Objects.requireNonNull(userId);
    }
}
