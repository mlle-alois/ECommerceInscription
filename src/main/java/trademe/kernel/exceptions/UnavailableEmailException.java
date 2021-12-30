package trademe.kernel.exceptions;

public final class UnavailableEmailException extends Exception {

    public UnavailableEmailException () {
        super("The email address provided is not available");
    }
}
