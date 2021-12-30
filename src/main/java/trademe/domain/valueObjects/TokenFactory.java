package trademe.domain.valueObjects;

import trademe.domain.valueObjects.Token;

import java.security.SecureRandom;
import java.util.Base64;

public final class TokenFactory {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    private TokenFactory() {
        throw new AssertionError();
    }

    public static Token generateToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return Token.of(base64Encoder.encodeToString(randomBytes));
    }
}
