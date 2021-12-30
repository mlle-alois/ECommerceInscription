package trademe.application.command;

import trademe.infrastructure.UserService;
import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;
import trademe.kernel.exceptions.UnavailableEmailException;
import trademe.domain.Contractor;
import trademe.domain.User;
import trademe.infrastructure.PaymentService;
import trademe.infrastructure.UserRepository;
import trademe.domain.valueObjects.UserId;

import java.util.Objects;

public final class RegisterContractorCommandHandler implements CommandHandler<RegisterContractor, UserId> {

    private final UserRepository userRepository;
    private final PaymentService paymentService;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final UserService userService;

    public RegisterContractorCommandHandler(UserRepository userRepository, PaymentService paymentService,
                                            EventDispatcher<Event> eventEventDispatcher, UserService userService) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.paymentService = Objects.requireNonNull(paymentService);
        this.eventEventDispatcher = Objects.requireNonNull(eventEventDispatcher);
        this.userService = Objects.requireNonNull(userService);
    }

    public UserId handle(RegisterContractor registerContractor) {
        final UserId userId = userRepository.nextIdentity();
        User user = Contractor.of(userId, registerContractor.userMail, registerContractor.lastname,
                registerContractor.firstname, registerContractor.password);
        if (!userService.isTheEmailAddressAvailable(user.getUserMail().getValue())) {
            try {
                throw new UnavailableEmailException();
            } catch (UnavailableEmailException e) {
                e.printStackTrace();
            }
        }
        paymentService.processPayment(user);
        userRepository.add(user);
        eventEventDispatcher.dispatch(new RegisterTradesmanEvent(userId));
        return userId;
    }
}
