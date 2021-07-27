package com.gildedrose;

import java.util.Objects;

public class LegendaryItem implements Item{
    private String name;

    private int sellIn;

    private int quality;

    public LegendaryItem(String name, int sellIn, int quality) {
      /*  if (quality>50){
            throw new RuntimeException();
        }*/
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
        if (!(o instanceof LegendaryItem))
            return false;
        LegendaryItem that = (LegendaryItem) o;
        return sellIn == that.sellIn && quality == that.quality && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
