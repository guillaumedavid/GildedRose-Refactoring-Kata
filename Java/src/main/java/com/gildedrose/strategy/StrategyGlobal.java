package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StrategyGlobal implements UpdateStrategy {

    public void update(Item i) {
        i.sellIn--;
    }

    protected void decreaseQuality(Item i) {
        if (i.quality > 0) {
            i.quality--;
        }
    }

    protected void increaseQuality(Item i) {
        if (i.quality < 50) {
            i.quality++;
        }
    }
}
