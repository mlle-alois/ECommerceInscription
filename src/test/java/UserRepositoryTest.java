public class UserRepositoryTest {

    /*UserRepository userRepository = new InMemoryUserRepository();
    UserRepository stubUserRepository = new StubUserRepository();

    @Test
    public void should_get_empty_list() {
        assertEquals(userRepository.getAll().size(), 0);
    }

    @Test
    public void should_get_not_empty_list() {
        assertEquals(stubUserRepository.getAll().size(), 2);
    }

    @Test
    public void should_successfully_register() {
        User user = User.createWithoutToken(UserMail.of("mail@mail.fr"), "User 1", "bobi", Password.of("secret"));
        assertTrue(userRepository.register(user));
    }

    @Test
    public void should_not_successfully_register() {
        User user = User.createWithoutToken(UserMail.of("mail@mail.fr"), "User 1", "bobi", Password.of("secret"));
        assertFalse(stubUserRepository.register(user));
    }

    @Test
    public void should_successfully_login() {
        assertTrue(stubUserRepository.login("mail2@mail.fr", "very secret"));
    }

    @Test
    public void should_not_successfully_login() {
        assertFalse(userRepository.login("mail2@mail.fr", "very secret"));
    }

    @Test
    public void should_return_that_the_user_is_already_logged_in() {
        User user = User.createWithoutToken(UserMail.of("mail@mail.fr"), "User 1", "bobi", Password.of("secret"));
        assertTrue(stubUserRepository.isTheUserAlreadyLoggedIn(user));
    }

    @Test
    public void should_return_that_the_user_is_not_already_logged_in() {
        User user = User.createWithoutToken(UserMail.of("mail@mail.fr"), "User 1", "bobi", Password.of("secret"));
        assertFalse(userRepository.isTheUserAlreadyLoggedIn(user));
    }

    @Test
    public void should_return_that_the_email_address_is_available() {
        assertTrue(userRepository.isTheEmailAddressAvailable("mail@mail.fr"));
    }

    @Test
    public void should_return_that_the_email_address_is_not_available() {
        assertFalse(stubUserRepository.isTheEmailAddressAvailable("mail@mail.fr"));
    }

    @Test
    public void should_not_find_the_user() {
        assertNull(userRepository.searchUserByMailAndPassword("abc@mail", "pswrd"));
    }

    @Test
    public void should_find_the_user() {
        assertNotNull(stubUserRepository.searchUserByMailAndPassword("mail2@mail.fr", "very secret"));
    }*/
}
