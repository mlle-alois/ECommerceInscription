package trademe.domain;

import trademe.kernel.Entity;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.Token;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;

import java.util.Objects;

public class User implements Entity<UserId> {

    private final UserId userId;
    private final UserMail userMail;
    private final String lastname;
    private final String firstname;
    private Password password;
    private Token token;

    protected User(UserId userId, UserMail userMail, String lastname, String firstname, Password password) {
        this.userId = Objects.requireNonNull(userId);
        this.userMail = Objects.requireNonNull(userMail);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.password = Objects.requireNonNull(password);
    }

    public UserId getId() {
        return userId;
    }

    @Override
    public UserId id() {
        return userId;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public UserMail getUserMail() {
        return userMail;
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

    public void changePassword(Password password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userMail, user.userMail) &&
                Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname) &&
                Objects.equals(password, user.password) && Objects.equals(token, user.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userMail, lastname, firstname, password, token);
    }

    @Override
    public String toString() {
        String result = "User id : " + userId.toString() + " \n" +
                "User Mail : " + userMail.toString() + " \n" +
                "Lastname : " + lastname + " \n" +
                "Firstname : " + firstname + " \n" +
                "Password : " + password.toString() + " \n";
        if(token != null) {
            result += "Token : " + token.toString() + "\n";
        }
        return result;
    }
}
