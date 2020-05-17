package cn.xpbootcamp.gildedrose;

public class GildedRost {
    int priceChangedBy(Commodity commodity, int passedDays) {
        int price = 0;
        switch (commodity.rule) {
            case normal:
                if (passedDays <= commodity.sellIn) {
                    price = (int) Math.round(commodity.quality * Math.pow(0.95, passedDays));
                } else {
                    Double tenDaysPrice = commodity.quality * Math.pow(0.95, commodity.sellIn);
                    price = (int) Math.round(tenDaysPrice * Math.pow(0.9, passedDays - commodity.sellIn));
                }

                break;
            case increment:
                price = (int) Math.round(commodity.quality * Math.pow(1.01, passedDays));
                if (price > 50) {
                    price = 50;
                }

                break;
            case forever:
                price = commodity.quality;
                break;
            case pass:
                int remainingDays = commodity.sellIn - passedDays;
                if (remainingDays < 10) {
                    if (remainingDays < 5) {
                        if (remainingDays <= 0) {
                            price = 0;
                        } else {
                            price = commodity.quality + 10 + (5 - remainingDays)*3;
                        }
                    } else {
                        price = commodity.quality + (10 - remainingDays)*2;
                    }
                } else {
                    price = commodity.quality;
                }
                break;
        }
        return price;
    }
}
