package com.mjc.stage2;

import com.mjc.stage2.event.RectangleEvent;

public interface Observer {
    void handleEvent(RectangleEvent event);
}
