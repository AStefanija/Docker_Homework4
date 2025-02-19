package com.example.orderservice;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.orderservice.service.OrderService;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class OrderServiceTests {

    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository);
    }

    @Test
    void testGetAllOrders() {
        Order order1 = new Order(1L, 101L, "Product A", 10);
        Order order2 = new Order(2L, 102L, "Product B", 5);
        List<Order> orders = Arrays.asList(order1, order2);
        when(orderRepository.findAll()).thenReturn(orders);
        List<Order> result = orderService.getAllOrders();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product A", result.get(0).getProduct());
        assertEquals(5, result.get(1).getQuantity());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void testPlaceOrder() {
        Order order = new Order();
        order.setProduct("Product C");
        order.setQuantity(20);
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order createdOrder = orderService.placeOrder(order);
        assertNotNull(createdOrder);
        assertEquals("Product C", createdOrder.getProduct());
        assertEquals(20, createdOrder.getQuantity());
        verify(orderRepository, times(1)).save(order);
    }
}
