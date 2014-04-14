package org.codepond.wizardroid.infrastructure;

import org.codepond.wizardroid.infrastructure.events.WizardEvent;

public interface Subscriber {
    void receive(WizardEvent event);
}
