package trademe.infrastructure;

import trademe.domain.User;

import java.util.Timer;

public final class FakePaymentService implements PaymentService {

    private final long FOUR_WEEKS_IN_MS = 2419200066L;

    @Override
    public void processPayment(User user) {
        Timer timer = new Timer();
        timer.schedule(new PaymentTask(user), 0, FOUR_WEEKS_IN_MS);
    }
}
