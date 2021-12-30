package trademe.kernel;

import trademe.kernel.exceptions.UnavailableEmailException;

public interface CommandBus {
    <C extends Command, R> R send(C command) throws UnavailableEmailException;
}
