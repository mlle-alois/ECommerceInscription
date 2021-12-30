package trademe.domain.valueObjects;

import trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class Token implements ValueObjectID {
    private final String value;

    private Token(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static Token of(String value) {
        return new Token(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value.equals(token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                '}';
    }
}
