package stub;

/*public final class StubUserRepository implements UserRepository {

    private final List<User> registeredUsers = new ArrayList<>();

    @Override
    public List<User> f() {
        registeredUsers.add(User.createWithoutToken(UserMail.of("mail@mail.fr"), "User 1", "bobi", Password.of("secret")));
        registeredUsers.add(User.createWithoutToken(UserMail.of("mail2@mail.fr"), "User 2", "jonny", Password.of("very secret")));
        return this.registeredUsers;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean login(String email, String password) {
        return true;
    }

    @Override
    public void logout(User user) {

    }

    @Override
    public void processPayment(User user) {

    }

    @Override
    public boolean isTheUserAlreadyLoggedIn(User user) {
        return true;
    }

    @Override
    public boolean isTheEmailAddressAvailable(String mail) {
        return false;
    }

    @Override
    public User searchUserByMailAndPassword(String email, String password) {
        registeredUsers.add(User.createWithoutToken(UserMail.of("mail2@mail.fr"), "User 2", "jonny", Password.of("very secret")));
        return registeredUsers.get(0);
    }
}*/
