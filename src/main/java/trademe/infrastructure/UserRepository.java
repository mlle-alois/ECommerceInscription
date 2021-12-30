package trademe.infrastructure;

import trademe.kernel.Repository;
import trademe.domain.User;
import trademe.domain.valueObjects.Password;
import trademe.domain.valueObjects.UserId;
import trademe.domain.valueObjects.UserMail;

import java.util.List;

public interface UserRepository extends Repository<UserId, User> {
    List<User> getAllUsers();

    User findByEmailAndPassword(UserMail mail, Password password);
}
