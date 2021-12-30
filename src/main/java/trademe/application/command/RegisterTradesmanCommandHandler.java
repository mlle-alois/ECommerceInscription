package trademe.application.command;

import trademe.domain.Tradesman;
import trademe.domain.User;
import trademe.domain.valueObjects.UserId;
import trademe.infrastructure.PaymentService;
import trademe.infrastructure.UserRepository;
import trademe.infrastructure.UserService;
import trademe.kernel.CommandHandler;
import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;
import trademe.kernel.exceptions.UnavailableEmailException;

import java.util.Objects;

public final class RegisterTradesmanCommandHandler implements CommandHandler<RegisterTradesman, UserId> {

    private final UserRepository userRepository;
    private final PaymentService paymentService;
    private final EventDispatcher<Event> eventEventDispatcher;
    private final UserService userService;

    public RegisterTradesmanCommandHandler(UserRepository userRepository, PaymentService paymentService,
                                           EventDispatcher<Event> eventEventDispatcher, UserService userService) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.paymentService = Objects.requireNonNull(paymentService);
        this.eventEventDispatcher = Objects.requireNonNull(eventEventDispatcher);
        this.userService = Objects.requireNonNull(userService);
    }

    public UserId handle(RegisterTradesman registerTradesman) {
        final UserId userId = userRepository.nextIdentity();
        User user = Tradesman.of(userId, registerTradesman.userMail, registerTradesman.lastname,
                registerTradesman.firstname, registerTradesman.password, registerTradesman.speciality, registerTradesman.aptitudeCertificates,
                registerTradesman.skills, registerTradesman.geographicZone, registerTradesman.dailyRate);
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
