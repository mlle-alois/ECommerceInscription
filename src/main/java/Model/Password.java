package Model;

public final class Password {
    private final String value;

    private Password(String value) {
        this.value = value;
    }

    public static Password of(String value) {
        return new Password(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
