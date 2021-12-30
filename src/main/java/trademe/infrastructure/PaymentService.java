package trademe.infrastructure;

import trademe.domain.User;

public interface PaymentService {
    void processPayment(User user);
}
