package cn.xpbootcamp.gildedrose;

public class GildedRost {
    int priceChangedBy(Commodity commodity, int afterDays) {
        int price = 0;
        switch (commodity.rule) {
            case normal:
                if (afterDays <= 10) {
                    price = (int) Math.round(commodity.quality * Math.pow(0.95, afterDays));
                } else {
                    Double tenDaysPrice = commodity.quality * Math.pow(0.95, 10);
                    price = (int) Math.round(tenDaysPrice * Math.pow(0.9, afterDays - 10));
                }

                break;
            default:
                break;
        }
        return price;
    }
}
