package com.tienda;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Product 1", 10.0);
        Product product2 = new Product("Product 2", 15.0);
        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        OrderCalculator calculator = new OrderCalculator();
        PaymentMethod paymentMethod = new PayPalPayment(); // O podemos usar CreditCardPayment
        OrderProcessor processor = new OrderProcessor(calculator, paymentMethod);
        processor.process(order);
    }
}