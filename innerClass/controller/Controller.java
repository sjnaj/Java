/**
 * @Author: fengsc
 * @Date: 2022-03-31 21:22:19
 * @LastEditTime: 2022-03-31 21:55:00
 */
package controller;

import java.util.ArrayList;

public class Controller {

    // A class from java.util to hold Event objects:
    private ArrayList<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0)
            // *Make a copy so you're not modifying the list
            // *while you're selecting the elements in it:
            for (Event e : new ArrayList<>(eventList))
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);    
                }
    }
}
