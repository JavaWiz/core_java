package com.javawiz.stream;

import com.javawiz.model.Order;
import java.util.stream.Collectors;

public class TopCustomerPerOrderStatus {

    public static void main(String[] args) {
        Order.getOrders()
            .stream()
            .collect(Collectors.groupingBy(
                Order::status,
                Collectors.collectingAndThen(
                    Collectors.maxBy((o1, o2) -> Double.compare(o1.amount(), o2.amount())),
                    orderOpt -> orderOpt.map(Order::customerId).orElse(null)
            )))
            .forEach((status, customer) ->
                System.out.println("Top customer for " + status + ": " + customer));
    }
}
