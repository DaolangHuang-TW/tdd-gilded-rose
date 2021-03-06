# TDD @Gilded Rose


## 开发环境
 - JDK1.8+
 
## 业务需求

"镶金玫瑰"！这是一家魔兽世界里的小商店。出售的商品也都是高质量的。但不妙的是，随着商品逐渐接近保质期，它们的质量也不断下滑。我们用一个IT系统来更新库存信息。

首先，简单介绍一下我们的系统：

- 所有商品都有一个`SellIn`值，这是商品距离过期的天数，最好在这么多天之内卖掉
- 所有商品都有一个`Quality`值，代表商品的价值
- 商品的`SellIn`值和`Quality`值，它们每天会发生变化，但是会有特例


商品的价格规则说明如下：

- 商品的价值永远不会小于0，也永远不会超过50
- 一旦过了保质期，`Quality`就以双倍的速度下滑
- 陈年干酪（`Aged Brie`）是一种特殊的商品，放得越久，价值反而越高
- 萨弗拉斯（`Sulfuras`）是一种传奇商品，没有保质期的概念，价值也不会下滑
- 后台门票（`Backstage pass`）和陈年干酪（`Aged Brie`）有相似之处：
	- 越接近演出日，商品的价值反而上升
	- 在演出前10天，价值每天上升2点
	- 演出前5天，价值每天上升3点
	- 一旦过了演出日，价值就马上变成0
	
	
## Tasking
跌价涨价规则：
1、每天跌5%， 过期后每天跌10%，价格为整数；
2、每天涨%1，价格为整数；
3、价格不会变化
4、过保前10天价格每天上升2点，过保前5天每天上升3点，过保后价格立马为0

Given 涨跌1，初始价格为50，保质期为10天
When 过了10天后
Then 售出价格为 30

Given 涨跌1，初始价格为50，保质期为10天
When 过了12天后
Then 售出价格为 24

Given 涨跌2，初始价格为40，保质期无
When 过了200天后
Then 价格为50

Given 涨跌2，初始价格为20，保质期无
When 过了10天后
Then 价格为22

Given 涨跌3, 初始价格为50，保质期无
When 过了1000天后
Then 价格为50

Given 涨跌4，初始价格20，保质期30天
When 过了24天
Then 价格为28

Given 涨跌4，初始价格20，保质期30天
When 过了28天
Then 价格为39

Given 涨跌4，初始价格20，保质期30天
When 过了30天
Then 价格为0










