import Factory.TokenFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TokenFactoryTest {

    @Test
    public void should_return_a_token() {
        assertNotNull(TokenFactory.generateToken().getValue());
    }

    @Test
    public void should_return_a_token_of_32_lenght() {
        assertEquals(TokenFactory.generateToken().getValue().length(), 32);
    }
}
