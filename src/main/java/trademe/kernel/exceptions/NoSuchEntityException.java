package trademe.kernel.exceptions;

import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(UserId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }

    public static NoSuchEntityException withEmailAndPassword(UserMail mail, Password password) {
        return new NoSuchEntityException(String.format("No entity found with EMAIL %s and password %s.", mail.getValue(), password.getValue()));
    }
}
