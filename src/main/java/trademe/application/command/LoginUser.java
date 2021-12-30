package trademe.application.command;

import trademe.kernel.Command;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserMail;

import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class LoginUser implements Command {

    public final UserMail userMail;
    public final Password password;

    public LoginUser(UserMail userMail, Password password) {
        this.userMail = Objects.requireNonNull(userMail);
        this.password = Objects.requireNonNull(password);
    }
}
