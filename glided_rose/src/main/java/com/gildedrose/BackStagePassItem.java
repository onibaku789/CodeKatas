package com.gildedrose;

import java.util.Objects;

public class BackStagePassItem implements Item {
    private final String name;

    private int sellIn;

    private int quality;

    public BackStagePassItem(String name, int sellIn, int quality) {
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
        if (sellIn > 10) {
            quality++;
        } else if (sellIn > 3) {
            quality += 2;
        } else if (sellIn > 0) {
            quality += 3;
        } else {
            quality = 0;
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
        if (!(o instanceof BackStagePassItem))
            return false;
        BackStagePassItem that = (BackStagePassItem) o;
        return sellIn == that.sellIn && quality == that.quality && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
