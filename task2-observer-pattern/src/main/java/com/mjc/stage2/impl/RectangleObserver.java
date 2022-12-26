package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    private static final RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        RectangleValues rectangleValues = rectangleWarehouse.get(rectangle.getId());
        if (rectangleValues != null) {
            rectangleValues.setPerimeter(
                    (rectangle.getSideA() + rectangle.getSideB()) * 2
            );
            rectangleValues.setSquare(
                    rectangle.getSideA() * rectangle.getSideB()
            );
            rectangleWarehouse.put(rectangle.getId(), rectangleValues);
        }
    }
}
