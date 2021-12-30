package trademe.infrastructure;

import trademe.kernel.exceptions.NoSuchEntityException;
import trademe.domain.User;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<UserId, User> users = new ConcurrentHashMap<>();
    //TODO map des utilisateurs connectés pour contrôler la validité du token ? Map<Token, User>

    @Override
    public UserId nextIdentity() {
        return UserId.of(count.incrementAndGet());
    }

    @Override
    public User findById(UserId id) {
        final User user = users.get(id);
        if (user == null) {
            throw NoSuchEntityException.withId(id);
        }
        return user;
    }

    @Override
    public User findByEmailAndPassword(UserMail mail, Password password) {
        for (User user : getAllUsers()) {
            if (mail.getValue().equals(user.getUserMail().getValue()) &&
                    password.getValue().equals(user.getPassword().getValue())) {
                return user;
            }
        }
        throw NoSuchEntityException.withEmailAndPassword(mail, password);
    }

    @Override
    public void add(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void delete(UserId id) {
        users.remove(id);
    }

    @Override
    public List<User> getAllUsers() {
        return List.copyOf(users.values());
    }
}
