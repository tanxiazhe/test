/**
 * 
 */
package com.designPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 *
 */
public class Broker {

    private final List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
