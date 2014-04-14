package org.codepond.wizardroid.infrastructure;

import org.codepond.wizardroid.infrastructure.events.WizardEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bus {
    private static final Bus instance = new Bus();
    private static Map<Class, List<Subscriber>> subscribers = new HashMap<Class, List<Subscriber>>();

    private Bus() {
    }

    public static Bus getInstance() {
        return instance;
    }

    public void post(WizardEvent event) {
        for (Class eventType : subscribers.keySet()) {
	        if (eventType.isInstance(event)) {
		        List<Subscriber> subscribersForEvent = subscribers.get(eventType);
		        for (Subscriber subscriber : subscribersForEvent) {
			        subscriber.receive(event);
		        }
	        }
        }
    }

    public void register(Subscriber subscriber, Class eventType) {
        if (!subscribers.containsKey(eventType)) {
	        List<Subscriber> subscriberList = new ArrayList<Subscriber>();
	        subscriberList.add(subscriber);
            subscribers.put(eventType, subscriberList);
        } else {
	        List<Subscriber> subscriberList = subscribers.get(eventType);
	        subscriberList.add(subscriber);
        }
    }

    public void unregister(Subscriber subscriber) {
	    for (Class eventType : subscribers.keySet()) {
		    List<Subscriber> subscribersForEvent = subscribers.get(eventType);
		    if (subscribersForEvent.contains(subscriber)) {
			    subscribersForEvent.remove(subscriber);
		    }
	    }
    }
}
