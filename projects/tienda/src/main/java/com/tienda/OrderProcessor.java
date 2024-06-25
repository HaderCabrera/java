package com.tienda;

class OrderProcessor {
    
    private OrderCalculator calculator;
    private PaymentMethod paymentMethod;

    public OrderProcessor(OrderCalculator calculator, PaymentMethod
    paymentMethod) {
        this.calculator = calculator;
        this.paymentMethod = paymentMethod;
    }
    public void process(Order order) {
        double amount = calculator.calculateTotal(order);
        paymentMethod.pay(amount);
    }
}