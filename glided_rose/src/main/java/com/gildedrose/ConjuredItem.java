package com.gildedrose;

import java.util.Objects;

public class ConjuredItem implements Item {
    public final String name;

    public int sellIn;

    public int quality;

    public ConjuredItem(String name, int sellIn, int quality) {

        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public void updateItem() {
        if (sellIn == 0) {
            quality -= 4;
        } else {
            quality -= 2;
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ConjuredItem))
            return false;
        ConjuredItem that = (ConjuredItem) o;
        return sellIn == that.sellIn && quality == that.quality && Objects.equals(name, that.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
