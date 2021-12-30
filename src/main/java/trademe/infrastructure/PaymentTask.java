package trademe.infrastructure;

import trademe.domain.User;

import java.util.Objects;
import java.util.TimerTask;

public final class PaymentTask extends TimerTask {
    private final User user;

    public PaymentTask(User user) {
        this.user = Objects.requireNonNull(user);
    }

    @Override
    public void run() {
        System.out.println("User " + user.getUserMail().getValue() + " was charged €8. Thanks for the payment.");
    }
}
