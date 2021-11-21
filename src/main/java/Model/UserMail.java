package Model;

public final class UserMail {

    private final String value;

    private UserMail(String value) {
        this.value = value;
    }

    public static UserMail of(String value) {
        return new UserMail(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
