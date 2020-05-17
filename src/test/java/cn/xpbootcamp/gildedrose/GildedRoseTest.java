package cn.xpbootcamp.gildedrose;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    GildedRost rost = new GildedRost();
    @org.junit.jupiter.api.Test
    void should_return_30_when_after_ten_days_given_rule_is_normal_sellIn_is_10_quality_is_50() {
        Commodity commodity = new Commodity();
        commodity.name = "Some";
        commodity.quality = 50;
        commodity.sellIn = 10;
        commodity.rule = PriceChangeRule.normal;

        assertEquals(30, rost.priceChangedBy(commodity, 10));
    }
}
