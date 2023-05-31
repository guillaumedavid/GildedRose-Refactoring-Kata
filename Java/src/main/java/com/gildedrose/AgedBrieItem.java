package com.gildedrose;

public class AgedBrieItem extends Item{

    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public  void Update(){
        this.sellIn--;
        increaseQuality();
        if (this.sellIn < 0) {
            increaseQuality();
        }
    }
}


