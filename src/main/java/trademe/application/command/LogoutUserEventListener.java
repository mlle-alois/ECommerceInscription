package trademe.application.command;

import trademe.kernel.EventListener;

public final class LogoutUserEventListener implements EventListener<LogoutUserEvent> {
    @Override
    public void listenTo(LogoutUserEvent event) {
        System.out.println("listening LogoutUserEvent.");
        System.out.println("The user " + event.getUserId().getValue() + " is disconnected");
    }
}
