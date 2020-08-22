package com.dp.Decorator;

public class ClientApp {
    public static void main(String[] args) {
        var plainBurger = new PlainBurger();

        FancyBurger fancyBurger = new FancyBurger(plainBurger);
        fancyBurger.addHalapenos(true);
        fancyBurger.addMushRooms(true);

        System.out.println(fancyBurger.getCost());

    }

}

class PlainBurger implements Burger {
    double cost = 0;

    public PlainBurger() {
        addBun(true);
        addCheese(true);
        addMayo(true);
    }

    public void addCheese(boolean b) {
        cost += 1;
    }

    public void addBun(boolean b) {
        cost += 3;
    }

    public void addMayo(boolean b) {
        cost += 0.5;
    }

    @Override
    public double getCost() {
        return cost;
    }
}

class FancyBurger implements Burger {
    double cost;

    PlainBurger plainBurger;

    public FancyBurger(PlainBurger plainBurger) {
        this.plainBurger = plainBurger;
        this.cost = plainBurger.cost;

    }

    public void addHalapenos(boolean b) {
        cost += 2;
    }

    public void addMushRooms(boolean b) {
        cost += 2;
    }

    @Override
    public double getCost() {
        return cost;
    }

}

