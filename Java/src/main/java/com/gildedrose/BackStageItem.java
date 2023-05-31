package com.gildedrose;

public class BackStageItem extends Item{

    public BackStageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public  void Update(){
        this.sellIn--;
        increaseQuality();

        if (this.sellIn < 10) {
            increaseQuality();
        }

        if (this.sellIn < 5) {
            increaseQuality();
        }

        if (this.sellIn < 0) {
            this.quality = 0;
        }
    }
}


