package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GildedRoseTest {

    private DefaultGlidedRose app;



    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("1", 11, 40, Arrays.asList(
                new BackStagePassItem("1", 10, 41),
                new NormalItem("1", 10, 39),
                new AgedItem("1", 10, 41),
                new ConjuredItem("1", 10, 38),
                new LegendaryItem("1", 11, 40)
            )),
            Arguments.of("2", 2, 4, Arrays.asList(
                new BackStagePassItem("2", 1, 7),
                new NormalItem("2", 1, 3),
                new AgedItem("2", 1, 5),
                new ConjuredItem("2", 1, 2),
                new LegendaryItem("2", 2, 4)
            )),
            Arguments.of("3", 20, 3, Arrays.asList(
                new BackStagePassItem("3", 19, 4),
                new NormalItem("3", 19, 2),
                new AgedItem("3", 19, 4),
                new ConjuredItem("3", 19, 1),
                new LegendaryItem("3", 20, 3)
            )),
            Arguments.of("4", 0, 5, Arrays.asList(
                new BackStagePassItem("4", -1, 0),
                new NormalItem("4", -1, 3),
                new AgedItem("4", -1, 7),
                new ConjuredItem("4", -1, 1),
                new LegendaryItem("4", 0, 5)
            ))
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void testUpdateQuality(String name, int sellIn, int quality, List<Item> expected) {
        List<Item> items = Arrays.asList(
            new BackStagePassItem(name, sellIn, quality),
            new NormalItem(name, sellIn, quality),
            new AgedItem(name, sellIn, quality),
            new ConjuredItem(name, sellIn, quality),
            new LegendaryItem(name, sellIn, quality)
        );
        app = new DefaultGlidedRose(items);
        app.updateQuality();
        List<Item> itemList = app.getItemList();
        assertEquals(expected, itemList);
    }

}
