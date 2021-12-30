package trademe.application.command;

import trademe.kernel.Command;
import trademe.exposition.PasswordResponse;

import java.util.Objects;

public final class ModifyUserPassword implements Command {

    public final int userId;
    public final PasswordResponse password;

    public ModifyUserPassword(int userId, PasswordResponse password) {
        this.userId = Objects.requireNonNull(userId);
        this.password = Objects.requireNonNull(password);
    }
}
