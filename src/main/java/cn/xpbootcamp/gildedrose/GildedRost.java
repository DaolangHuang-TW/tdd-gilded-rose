package cn.xpbootcamp.gildedrose;

public class GildedRost {
    int priceChangedBy(Commodity commodity, int afterDays) {
        int price = 0;
        switch (commodity.rule) {
            case normal:
                price = (int) Math.round(commodity.quality * Math.pow(0.95, afterDays));
                break;
            default:
                break;
        }
        return price;
    }
}
