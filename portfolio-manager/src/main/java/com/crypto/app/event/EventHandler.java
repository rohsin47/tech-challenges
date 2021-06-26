package com.crypto.app.event;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author rohsi
 *
 */
@Component
public class EventHandler {

	private Map<Class<? extends Event>, EventListener> handlers;

	public EventHandler() {
		handlers = new HashMap<>();
	}

	public void registerHandler(Class<? extends Event> event, EventListener handler) {
		handlers.put(event, handler);
	}
	
	public void deregisterHandler(Class<? extends Event> event) {
		handlers.remove(event);
	}

	public void handle(Event event) {
		EventListener handler = handlers.get(event.getClass());
		if (handler != null) {
			handler.onEvent(event);
		}
	}

    public Map<Class<? extends Event>, EventListener> getHandlers() {
        return handlers;
    }

}
