package com.example.insw;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CalculatorTestCase {

    @Test
    void multiply_whenNumbersArePositive_returnsCorrectResult() {
        Calculator calculator = new Calculator();

        int result = calculator.multiply(5, 4);

        assertEquals(20, result);
    }
    @Test
void multiply_whenOneNumberIsZero_returnsZero() {
    Calculator calculator = new Calculator();

    int result = calculator.multiply(5, 0);

    assertEquals(0, result);
}
@Test
void multiply_whenNumbersAreNegative_returnsCorrectResult() {
    Calculator calculator = new Calculator();

    int result = calculator.multiply(-5, -4);

    assertEquals(20, result);
}
@Test
void concat_whenStringsAreValid_returnsConcatenatedString() {
    Calculator calculator = new Calculator();

    String result = calculator.concat("Hola ", "Mundo");

    assertEquals("Hola Mundo", result);
}
@Test
void concat_whenSecondStringIsNull_returnsEmpty() {
    Calculator calculator = new Calculator();

    String result = calculator.concat("Hola", null);

    assertEquals("empty", result);
}
@Test
void sum_whenValuesArePositive_returnsCorrectResult() {
    Calculator calculator = new Calculator();

    double result = calculator.sum(5.5, 4.5);

    assertEquals(10.0, result);
}
@Test
void sum_whenValuesAreNegative_returnsCorrectResult() {
    Calculator calculator = new Calculator();

    double result = calculator.sum(-5.5, -4.5);

    assertEquals(-10.0, result);
}
@Test
void discount_whenPercentIsValid_returnsDiscountedAmount() {
    Calculator calculator = new Calculator();

    double result = calculator.discount(100.0, 20.0);

    assertEquals(80.0, result);
}
@Test
void discount_whenPercentIsZero_returnsOriginalAmount() {
    Calculator calculator = new Calculator();

    double result = calculator.discount(100.0, 0.0);

    assertEquals(100.0, result);
}
@Test
void discount_whenPercentIs100_returnsZero() {
    Calculator calculator = new Calculator();

    double result = calculator.discount(100.0, 100.0);

    assertEquals(0.0, result);
}
@Test
void discount_whenPercentIsNegative_throwsException() {
    Calculator calculator = new Calculator();

    assertThrows(
        IllegalArgumentException.class,
        () -> calculator.discount(100.0, -10.0)
    );
}
@Test
void discount_whenPercentIsGreaterThan100_throwsException() {
    Calculator calculator = new Calculator();

    assertThrows(
        IllegalArgumentException.class,
        () -> calculator.discount(100.0, 110.0)
    );
}
@Test
void calculateTotal_whenListHasAmounts_returnsTotal() {
    Calculator calculator = new Calculator();

    List<Double> amounts = Arrays.asList(10.0, 20.0, 30.0);

    double result = calculator.calculateTotal(amounts);

    assertEquals(60.0, result);
}
@Test
void calculateTotal_whenListIsEmpty_returnsZero() {
    Calculator calculator = new Calculator();

    List<Double> amounts = Arrays.asList();

    double result = calculator.calculateTotal(amounts);

    assertEquals(0.0, result);
}
}