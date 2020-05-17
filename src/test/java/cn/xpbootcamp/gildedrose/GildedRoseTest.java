package cn.xpbootcamp.gildedrose;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    GildedRost rost = new GildedRost();
    @org.junit.jupiter.api.Test
    void should_return_30_when_after_10_days_given_rule_is_normal_sellIn_is_10_quality_is_50() {
        Commodity commodity = new Commodity();
        commodity.name = "Some";
        commodity.quality = 50;
        commodity.sellIn = 10;
        commodity.rule = PriceChangeRule.normal;

        assertEquals(30, rost.priceChangedBy(commodity, 10));
    }

    @org.junit.jupiter.api.Test
    void should_return_24_when_after_12_days_given_rule_is_normal_sellIn_is_10_quality_is_50() {
        Commodity commodity = new Commodity();
        commodity.name = "Some";
        commodity.quality = 50;
        commodity.sellIn = 10;
        commodity.rule = PriceChangeRule.normal;

        assertEquals(24, rost.priceChangedBy(commodity, 12));
    }

    @org.junit.jupiter.api.Test
    void should_return_50_when_after_200_days_given_rule_is_increment_sellIn_is_none_quality_is_40() {
        Commodity commodity = new Commodity();
        commodity.name = "Aged Brie";
        commodity.quality = 40;
        commodity.sellIn = 0;
        commodity.rule = PriceChangeRule.increment;

        assertEquals(50, rost.priceChangedBy(commodity, 200));
    }

    @org.junit.jupiter.api.Test
    void should_return_22_when_after_10_days_given_rule_is_increment_sellIn_is_none_quality_is_20() {
        Commodity commodity = new Commodity();
        commodity.name = "Aged Brie";
        commodity.quality = 20;
        commodity.sellIn = 0;
        commodity.rule = PriceChangeRule.increment;

        assertEquals(22, rost.priceChangedBy(commodity, 10));
    }

    @org.junit.jupiter.api.Test
    void should_return_50_when_after_1000_days_given_rule_is_forever_sellIn_is_none_quality_is_50() {
        Commodity commodity = new Commodity();
        commodity.name = "Sulfuras";
        commodity.quality = 50;
        commodity.sellIn = 0;
        commodity.rule = PriceChangeRule.forever;

        assertEquals(50, rost.priceChangedBy(commodity, 1000));
    }

    @org.junit.jupiter.api.Test
    void should_return_28_when_after_24_days_given_rule_is_pass_sellIn_is_30_quality_is_20() {
        Commodity commodity = new Commodity();
        commodity.name = "Backstage pass";
        commodity.quality = 20;
        commodity.sellIn = 30;
        commodity.rule = PriceChangeRule.pass;

        assertEquals(28, rost.priceChangedBy(commodity, 24));
    }
}
