package trademe.application.query;

import trademe.domain.User;
import trademe.infrastructure.UserRepository;
import trademe.kernel.QueryHandler;

import java.util.Objects;

public final class RetrieveUserHandler implements QueryHandler<RetrieveUser, User> {

    private final UserRepository userRepository;

    public RetrieveUserHandler(UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
    }

    @Override
    public User handle(RetrieveUser retrieveUser) {
        return userRepository.findById(retrieveUser.userId);
    }
}
