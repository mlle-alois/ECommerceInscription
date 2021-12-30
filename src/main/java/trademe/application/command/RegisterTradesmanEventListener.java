package trademe.application.command;

import trademe.kernel.EventListener;

public final class RegisterTradesmanEventListener implements EventListener<RegisterTradesmanEvent> {
    @Override
    public void listenTo(RegisterTradesmanEvent event) {
        System.out.println("listening RegisterTradesmanEvent.");
        System.out.println("================================= Registration finalized, you can now connect =================================");
    }
}
