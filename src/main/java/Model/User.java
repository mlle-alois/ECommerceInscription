package Model;

import java.util.Objects;

public final class User {

    private final UserMail userMail;
    private final String lastname;
    private final String firstname;
    private final Password password;
    private Token token;

    private User(UserMail userMail, String lastname, String firtstname, Password password) {
        this.userMail = Objects.requireNonNull(userMail);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firtstname);
        this.password = Objects.requireNonNull(password);
    }

    public static User createWithoutToken(UserMail userMail, String lastname, String firstname, Password password) {
        return new User(userMail, lastname, firstname, password);
    }

    public UserMail getUserMail() {
        return userMail;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Password getPassword() {
        return password;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
