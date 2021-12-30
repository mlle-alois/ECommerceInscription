package trademe;

import trademe.application.query.RetrieveUser;
import trademe.application.query.RetrieveUserHandler;
import trademe.kernel.*;
import trademe.application.command.*;
import trademe.application.query.RetrieveUsers;
import trademe.application.query.RetrieveUsersHandler;
import trademe.infrastructure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserService userService() {
        return new UserService(userRepository());
    }

    @Bean
    public PaymentService paymentService() {
        return new FakePaymentService();
    }

    // ---------------- COMMAND ----------------

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap =
                Collections.singletonMap(RegisterTradesman.class, new RegisterTradesmanCommandHandler(userRepository(), paymentService(), eventEventDispatcher(), userService()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ModifyUserPasswordEvent.class, List.of(new ModifyUserPasswordEventListener()));
        listenerMap.put(RegisterTradesmanEvent.class, List.of(new RegisterTradesmanEventListener()));
        listenerMap.put(RegisterContractorEvent.class, List.of(new RegisterContractorEventListener()));
        listenerMap.put(LoginUserEvent.class, List.of(new LoginUserEventListener()));
        listenerMap.put(LogoutUserEvent.class, List.of(new LogoutUserEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public RegisterTradesmanCommandHandler registerTradesmanCommandHandler() {
        return new RegisterTradesmanCommandHandler(userRepository(), paymentService(), eventEventDispatcher(), userService());
    }

    @Bean
    public RegisterContractorCommandHandler registerContractorCommandHandler() {
        return new RegisterContractorCommandHandler(userRepository(), paymentService(), eventEventDispatcher(), userService());
    }

    @Bean
    public ModifyUserPasswordCommandHandler modifyUserPasswordCommandHandler() {
        return new ModifyUserPasswordCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public LoginUserCommandHandler loginUserCommandHandler() {
        return new LoginUserCommandHandler(userRepository(), eventEventDispatcher(), userService());
    }

    @Bean
    public LogoutUserCommandHandler logoutUserCommandHandler() {
        return new LogoutUserCommandHandler(userRepository(), eventEventDispatcher());
    }

    // ---------------- QUERY ----------------

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveUsers.class, new RetrieveUsersHandler(userRepository()));
        queryHandlerMap.put(RetrieveUser.class, new RetrieveUserHandler(userRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveUsersHandler retrieveUsersHandler() {
        return new RetrieveUsersHandler(userRepository());
    }

    @Bean
    public RetrieveUserHandler retrieveUserHandler() {
        return new RetrieveUserHandler(userRepository());
    }
}
