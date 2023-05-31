package com.gildedrose;

public class NormalItem extends Item{

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public  void Update(){
        this.sellIn--;
        decreaseQuality();
        if (this.sellIn < 0) {
            decreaseQuality();
        }
    }
}


