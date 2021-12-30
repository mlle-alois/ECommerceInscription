package trademe.application.query;

import trademe.kernel.QueryHandler;
import trademe.domain.User;
import trademe.infrastructure.UserRepository;

import java.util.List;
import java.util.Objects;

public final class RetrieveUsersHandler implements QueryHandler<RetrieveUsers, List<User>> {

    private final UserRepository userRepository;

    public RetrieveUsersHandler(UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
    }

    @Override
    public List<User> handle(RetrieveUsers query) {
        return userRepository.getAllUsers();
    }
}
