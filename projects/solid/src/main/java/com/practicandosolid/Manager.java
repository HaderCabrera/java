package com.practicandosolid;

class Manager extends Employ {
    public Manager(String name, double salary) {
    super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.20; // Managers have a higher bonus
    }
}