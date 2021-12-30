package trademe.application.command;

import trademe.kernel.EventListener;

public final class LoginUserEventListener implements EventListener<LoginUserEvent> {
    @Override
    public void listenTo(LoginUserEvent event) {
        System.out.println("listening LoginUserEvent.");
        System.out.println("The user " + event.getUserId().getValue() + " is connected");
    }
}
