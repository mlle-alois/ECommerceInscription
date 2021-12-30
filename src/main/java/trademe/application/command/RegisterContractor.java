package trademe.application.command;

import trademe.kernel.Command;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserMail;

import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class RegisterContractor implements Command {

    public final UserMail userMail;
    public final String lastname;
    public final String firstname;
    public final Password password;

    public RegisterContractor(UserMail userMail, String lastname, String firstname, Password password) {
        this.userMail = Objects.requireNonNull(userMail);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.password = Objects.requireNonNull(password);
    }
}
