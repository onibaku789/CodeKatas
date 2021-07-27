package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class DefaultGlidedRose implements GildedRose {
    private final List<Item> itemList;

    public DefaultGlidedRose(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void updateQuality() {
        itemList.forEach(Item::updateItem);
    }

    public List<Item> getItemList() {
        return new ArrayList<>(itemList);
    }
}
