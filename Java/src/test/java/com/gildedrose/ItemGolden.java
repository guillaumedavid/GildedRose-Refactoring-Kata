package com.gildedrose;

public class ItemGolden {

    public String name;

    public int sellIn;

    public int quality;


    public ItemGolden(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }


    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
