package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    private Map<String,UpdateStrategy> specificStrategies = new HashMap(
        Map.of(
            AGED_BRIE, new StrategyBrie(),
            BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, new StrategyBackstage(),
            SULFURAS_HAND_OF_RAGNAROS, new StrategySulfuras()
        )
    );

    private UpdateStrategy normalStrategy = new StrategyNormal();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
           specificStrategies.getOrDefault(items[i].name, normalStrategy).update(items[i]);
        }
    }




}
