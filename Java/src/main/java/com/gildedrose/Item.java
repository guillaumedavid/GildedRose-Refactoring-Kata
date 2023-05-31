package com.gildedrose;

public abstract class Item {

    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
    public abstract void Update();
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected void decreaseQuality() {
        if (this.quality > 0) {
           this.quality--;
        }
    }


    protected void increaseQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }


}


