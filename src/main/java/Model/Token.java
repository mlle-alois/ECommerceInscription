package Model;

public final class Token {
    private final String value;

    private Token(String value) {
        this.value = value;
    }

    public static Token of(String value) {
        return new Token(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
