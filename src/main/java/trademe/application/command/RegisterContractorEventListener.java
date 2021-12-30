package trademe.application.command;

import trademe.kernel.EventListener;

public final class RegisterContractorEventListener implements EventListener<RegisterContractorEvent> {
    @Override
    public void listenTo(RegisterContractorEvent event) {
        System.out.println("listening RegisterContractorEvent.");
    }
}
