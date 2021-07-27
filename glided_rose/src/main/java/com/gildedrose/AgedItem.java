package com.gildedrose;

import java.util.Objects;

public class AgedItem implements Item {

    public String name;

    public int sellIn;

    public int quality;

    public AgedItem(String name, int sellIn, int quality) {
        if (quality > 50) {
            throw new RuntimeException();
        }
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public void updateItem() {
        if (sellIn == 0) {
            quality += 2;
        } else {
            quality++;
        }
        if (quality > 50) {
            quality = 50;
        }
        sellIn--;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AgedItem))
            return false;
        AgedItem agedItem = (AgedItem) o;
        return sellIn == agedItem.sellIn && quality == agedItem.quality && Objects.equals(name, agedItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
