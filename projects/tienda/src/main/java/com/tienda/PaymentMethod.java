package com.tienda;

interface PaymentMethod {
    void pay(double amount);
}
    // Implementación de Tarjeta de Crédito
    class CreditCardPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Paying with credit card: " + amount);
        }
    }
    // Implementación de PayPal
    class PayPalPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Paying with PayPal: " + amount);
        }
    }


