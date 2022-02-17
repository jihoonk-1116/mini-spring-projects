package com.example2.secondapp.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
