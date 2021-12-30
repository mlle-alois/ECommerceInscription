package trademe.domain;

import java.util.Objects;

public final class Address {

    private final String city;

    private Address(String city) {
        this.city = Objects.requireNonNull(city);
    }

    public static Address of(String city) {
        return Address.of(city);
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
