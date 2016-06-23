package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> Rs;

    public EventIncrementManager() {
        this.Rs = new AtomicReference();
    }

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.Rs.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    protected abstract EventIncrementCache hx();

    public void m731l(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.Rs.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = hx();
            if (!this.Rs.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.Rs.get();
            }
        }
        eventIncrementCache.m730u(str, i);
    }
}
