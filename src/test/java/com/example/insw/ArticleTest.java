package com.example.insw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.insw.model.Article;

public class ArticleTest {

    @Test
    void getGrossAmount_returnsCorrectAmount() {
        Article article = new Article("Laptop", 2, 50.0, 10.0);

        assertEquals(100.0, article.getGrossAmount(), 0.001);
    }

    @Test
    void getDiscountedAmount_returnsCorrectAmount() {
        Article article = new Article("Laptop", 2, 50.0, 10.0);

        assertEquals(90.0, article.getDiscountedAmount(), 0.001);
    }
}