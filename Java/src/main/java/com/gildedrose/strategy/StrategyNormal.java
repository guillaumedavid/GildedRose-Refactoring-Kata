package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StrategyNormal extends StrategyGlobal implements UpdateStrategy {

    public void update(Item i) {
        super.update(i);

        decreaseQuality(i);
        if (i.sellIn < 0) {
            decreaseQuality(i);
        }
    }
}
