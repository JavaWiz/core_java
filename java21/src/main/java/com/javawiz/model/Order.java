package com.javawiz.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Order(int orderId, OrderStatus status, double amount, int customerId) {
    public static List<Order> getOrders() {
        return List.of(
            Order.builder().orderId(1).status(OrderStatus.COMPLETED).amount(250.75).customerId(101).build(),
            Order.builder().orderId(2).status(OrderStatus.PENDING).amount(100.00).customerId(102).build(),
            Order.builder().orderId(3).status(OrderStatus.CANCELLED).amount(300.50).customerId(103).build(),
            Order.builder().orderId(4).status(OrderStatus.COMPLETED).amount(450.00).customerId(104).build(),
            Order.builder().orderId(5).status(OrderStatus.PENDING).amount(150.25).customerId(105).build(),
            Order.builder().orderId(6).status(OrderStatus.COMPLETED).amount(500.00).customerId(106).build(),
            Order.builder().orderId(7).status(OrderStatus.CANCELLED).amount(200.00).customerId(107).build(),
            Order.builder().orderId(8).status(OrderStatus.COMPLETED).amount(350.75).customerId(108).build(),
            Order.builder().orderId(9).status(OrderStatus.PENDING).amount(400.00).customerId(109).build(),
            Order.builder().orderId(10).status(OrderStatus.COMPLETED).amount(600.50).customerId(110).build(),
            Order.builder().orderId(11).status(OrderStatus.CANCELLED).amount(275.00).customerId(111).build(),
            Order.builder().orderId(12).status(OrderStatus.COMPLETED).amount(425.25).customerId(112).build()
        );
    }
}
