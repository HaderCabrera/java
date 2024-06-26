    package com.tienda;

class OrderCalculator {
    public double calculateTotal(Order order) {
        double total = 0;
        for (Product product : order.getProducts()) {
            total += product.getPrice();
        }
        return total;
    }
}
