package trademe.infrastructure;

import trademe.kernel.Event;
import trademe.kernel.EventDispatcher;
import trademe.kernel.EventListener;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class DefaultEventDispatcher<E extends Event> implements EventDispatcher<E> {

    private final Map<Class<E>, List<EventListener<E>>> eventListenersMap;

    public DefaultEventDispatcher(Map<Class<E>, List<EventListener<E>>> eventListenersMap) {
        this.eventListenersMap = Objects.requireNonNull(eventListenersMap);
    }

    @Override
    public void dispatch(E event) {
        final List<EventListener<E>> eventListeners = eventListenersMap.get(event.getClass());
        if (eventListeners != null) {
            eventListeners.forEach(eEventListener -> eEventListener.listenTo(event));
        }
    }
}
