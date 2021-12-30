package trademe.domain.valueObjects;

import trademe.kernel.ValueObjectID;

import java.util.Objects;

public final class UserMail implements ValueObjectID {

    private final String value;

    private UserMail(String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static UserMail of(String value) {
        return new UserMail(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMail userMail = (UserMail) o;
        return value.equals(userMail.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "UserMail{" +
                "value=" + value +
                '}';
    }
}
