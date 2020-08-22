package com.dp.Strategy;

import lombok.extern.slf4j.Slf4j;

interface SellingStrategy {
    int sell();
}

@Slf4j
public class Main {

    public static void main(String[] args) {

        log.info("test");

        MarketingCampaign x = new MarketingCampaign(new Door2DoorStrategy());
        System.out.println(x.countMoney());

        x.changeStrategy(new EmailSellingStrategy());
        System.out.println(x.countMoney());

    }
}

class MarketingCampaign {

    private SellingStrategy sellingStrategy;

    public MarketingCampaign(SellingStrategy sellingStrategy) {
        this.sellingStrategy = sellingStrategy;
    }

    int countMoney() {
        return sellingStrategy.sell();
    }

    public void changeStrategy(SellingStrategy sellingStrategy) {
        this.sellingStrategy = sellingStrategy;
    }
}

class Door2DoorStrategy implements SellingStrategy {
    @Override
    public int sell() {
        return 25;
    }
}

class EmailSellingStrategy implements SellingStrategy {
    @Override
    public int sell() {
        return 50;
    }
}
