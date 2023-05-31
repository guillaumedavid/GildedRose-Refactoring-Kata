package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StrategyBackstage extends StrategyGlobal implements UpdateStrategy {

    public void update(Item i) {
        super.update(i);

        increaseQuality(i);

        if (i.sellIn < 10) {
            increaseQuality(i);
        }

        if (i.sellIn < 5) {
            increaseQuality(i);
        }

        if (i.sellIn < 0) {
            i.quality = 0;
        }
    }
}
