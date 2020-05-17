package cn.xpbootcamp.gildedrose;

public class GildedRost {
    int priceChangedBy(Commodity commodity, int afterDays) {
        int price = 0;
        switch (commodity.rule) {
            case normal:
                if (afterDays <= commodity.sellIn) {
                    price = (int) Math.round(commodity.quality * Math.pow(0.95, afterDays));
                } else {
                    Double tenDaysPrice = commodity.quality * Math.pow(0.95, commodity.sellIn);
                    price = (int) Math.round(tenDaysPrice * Math.pow(0.9, afterDays - commodity.sellIn));
                }

                break;
            case increment:
                price = (int) Math.round(commodity.quality * Math.pow(1.01, afterDays));
                if (price > 50) {
                    price = 50;
                }

                break;
            case forever:
                price = commodity.quality;
                break;
            case pass:
                int clearDays = commodity.sellIn - afterDays;
                if (clearDays < 10) {
                    if (clearDays < 5) {
                        if (clearDays <= 0) {
                            price = 0;
                        } else {
                            price = commodity.quality + 10 + (5 - clearDays)*3;
                        }
                    } else {
                        price = commodity.quality + (10 - clearDays)*2;
                    }
                } else {
                    price = commodity.quality;
                }
                break;
        }
        return price;
    }
}
