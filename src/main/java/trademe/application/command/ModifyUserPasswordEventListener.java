package trademe.application.command;

import trademe.kernel.EventListener;

public final class ModifyUserPasswordEventListener implements EventListener<ModifyUserPasswordEvent> {
    @Override
    public void listenTo(ModifyUserPasswordEvent event) {
        System.out.println("Listening ModifyUserPasswordEvent.");
    }
}
