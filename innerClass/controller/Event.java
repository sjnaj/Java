/**
 * @Author: fengsc
 * @Date: 2022-03-31 21:17:40
 * @LastEditTime: 2022-03-31 22:05:17
 */
package controller;

import java.time.*;

public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;

    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() { // *Allows restarting
        eventTime = Instant.now().plus(delayTime);
    }

    public boolean ready() {//超过eventTime则为ready
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();

}
