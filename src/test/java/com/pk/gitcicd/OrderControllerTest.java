package com.pk.gitcicd;
import com.pk.gitcicd.controller.OrderController;
import com.pk.gitcicd.model.Order;
import com.pk.gitcicd.model.Product;
import com.pk.gitcicd.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void testCreateOrderSuccess() {

        Product product1 = new Product();
        product1.setId(1);
        product1.setProductName("Product 1");
        product1.setProductPrice("10");

        Product product2 = new Product();
        product2.setId(2);
        product2.setProductName("Product 2");
        product2.setProductPrice(String.valueOf(20));

        List<Product> products = Arrays.asList(product1, product2);

        Order order = new Order();
        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());

        when(orderService.createOrder(any(Order.class))).thenReturn(order);

        ResponseEntity<Order> response = orderController.createOrder(order);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(order, response.getBody());
    }
    @Test
    public void testCreateOrderSuccessWitBdd() {

        // Given
        Product product1 = new Product();
        product1.setId(1);
        product1.setProductName("Product 1");
        product1.setProductPrice("10");

        Product product2 = new Product();
        product2.setId(2);
        product2.setProductName("Product 2");
        product2.setProductPrice(String.valueOf(20));

        List<Product> products = Arrays.asList(product1, product2);

        Order order = new Order();
        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());

        given(orderService.createOrder(any(Order.class))).willReturn(order);

        // When
        ResponseEntity<Order> response = orderController.createOrder(order);

        // Then
        assertThat(response.getStatusCodeValue(), equalTo(200));
        assertThat(response.getBody(), equalTo(order));
    }
}
