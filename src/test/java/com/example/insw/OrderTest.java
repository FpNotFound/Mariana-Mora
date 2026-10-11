package com.example.insw;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.insw.model.Article;
import com.example.insw.model.Order;

public class OrderTest {

    @Test
    void getGrossTotal_returnsCorrectTotal() {
        Article article1 = new Article("Laptop", 2, 50.0, 10.0);
        Article article2 = new Article("Mouse", 3, 10.0, 0.0);

        Order order = new Order(
                "ORD001",
                Arrays.asList(article1, article2)
        );

        assertEquals(130.0, order.getGrossTotal(), 0.001);
    }

    @Test
    void getDiscountedTotal_returnsCorrectTotal() {
        Article article1 = new Article("Laptop", 2, 50.0, 10.0);
        Article article2 = new Article("Mouse", 3, 10.0, 0.0);

        Order order = new Order(
                "ORD001",
                Arrays.asList(article1, article2)
        );

        assertEquals(120.0, order.getDiscountedTotal(), 0.001);
    }
}
