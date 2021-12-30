package trademe.domain.valueObjects;

import trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class Password implements ValueObjectID {
    private final String value;

    private Password(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static Password of(String value) {
        return new Password(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return value.equals(password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Password{" +
                "value=" + value +
                '}';
    }
}
