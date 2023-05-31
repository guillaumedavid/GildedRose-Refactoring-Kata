package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    Item[] items = new Item[]{
        new NormalItem("+5 Dexterity Vest", 10, 20), //
        new AgedBrieItem("Aged Brie", 2, 0), //
        new NormalItem("Elixir of the Mongoose", 5, 7), //
        new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80), //
        new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80),
        new BackStageItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new BackStageItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new BackStageItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        new NormalItem("Conjured Mana Cake", 3, 6)};

    ItemGolden[] itemsGolden = new ItemGolden[]{
        new ItemGolden("+5 Dexterity Vest", 10, 20), //
        new ItemGolden("Aged Brie", 2, 0), //
        new ItemGolden("Elixir of the Mongoose", 5, 7), //
        new ItemGolden("Sulfuras, Hand of Ragnaros", 0, 80), //
        new ItemGolden("Sulfuras, Hand of Ragnaros", -1, 80),
        new ItemGolden("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new ItemGolden("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new ItemGolden("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        new ItemGolden("Conjured Mana Cake", 3, 6)};


    @Test
    void foo() {
        Item[] items = new NormalItem[]{new NormalItem("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isEqualTo("foo");
    }

    @Test
    void Oneday() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items).extracting(item -> item.sellIn).containsExactly(9, 1, 4, 0, -1, 14, 9, 4, 2);
        assertThat(app.items).extracting(item -> item.quality).containsExactly(19, 1, 6, 80, 80, 21, 50, 50, 5);
    }

    @Test
    void Twoday() {
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertThat(app.items).extracting(item -> item.sellIn).containsExactly(8, 0, 3, 0, -1, 13, 8, 3, 1);
        assertThat(app.items).extracting(item -> item.quality).containsExactly(18, 2, 5, 80, 80, 22, 50, 50, 4);
    }

    @Test
    void GoldenTest100Loop() {
        GildedRose app = new GildedRose(items);
        GildedRoseGolden appGolden = new GildedRoseGolden(itemsGolden);

        for (int day = 0; day < 100; day++) {
            app.updateQuality();
            appGolden.updateQuality();
            assertThat(app.items).extracting(item -> item.sellIn).containsExactly(Arrays.stream(appGolden.items).map(item -> item.sellIn).toArray(Integer[]::new));
            assertThat(app.items).extracting(item -> item.quality).containsExactly(Arrays.stream(appGolden.items).map(item -> item.quality).toArray(Integer[]::new));
        }
    }


}
