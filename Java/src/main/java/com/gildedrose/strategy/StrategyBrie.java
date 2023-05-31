package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StrategyBrie extends StrategyGlobal implements UpdateStrategy {

    public void update(Item i) {
        super.update(i);

        this.increaseQuality(i);
        if (i.sellIn < 0) {
            increaseQuality(i);
        }
    }
}
