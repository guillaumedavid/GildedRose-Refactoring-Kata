package com.gildedrose;

import com.gildedrose.strategy.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String NORMAL_ITEM = "NORMAL";
    Item[] items;

    public Map<String,UpdateStrategy> updateStrategy = new HashMap(
        Map.of(
            AGED_BRIE, new StrategyBrie(),
            BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, new StrategyBackstage(),
            SULFURAS_HAND_OF_RAGNAROS, new StrategySulfuras(),
            NORMAL_ITEM, new StrategyNormal()
        )
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                continue;
            }
            items[i].sellIn = items[i].sellIn - 1;

            //premier bloc
            if (items[i].name.equals(AGED_BRIE)) {
                updateAgedBrie(i);
            } else if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                updateBackstage(i);
            } else {
                updateNormalItem(i);
            }
        }
    }

    private void updateNormalItem(int i) {
        decreaseQuality(i);
        if (items[i].sellIn < 0) {
            decreaseQuality(i);
        }
    }

    private void updateAgedBrie(int i) {
        increaseQuality(i);
        if (items[i].sellIn < 0) {
            increaseQuality(i);
        }
    }

    private void updateBackstage(int i) {
        increaseQuality(i);

        if (items[i].sellIn < 10) {
            increaseQuality(i);
        }

        if (items[i].sellIn < 5) {
            increaseQuality(i);
        }

        if (items[i].sellIn < 0) {
            items[i].quality = 0;
        }
    }

    private void decreaseQuality(int i) {
        if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1;
        }
    }

    private void increaseQuality(int i) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
        }
    }
}
