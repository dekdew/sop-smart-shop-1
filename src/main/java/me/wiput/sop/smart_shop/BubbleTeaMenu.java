package me.wiput.sop.smart_shop;

public class BubbleTeaMenu {

  private boolean isLarge;
  private int price;
  private String name;
  private BubbleTea bubbleTea;

  public BubbleTeaMenu(boolean isLarge, int price, String name,
      BubbleTea bubbleTea) {
    this.isLarge = isLarge;
    this.name = name;
    this.bubbleTea = bubbleTea;
    this.setPrice(price);
  }

  public BubbleTea getBubbleTea() {
    return bubbleTea;
  }

  public void setBubbleTea(BubbleTea bubbleTea) {
    this.bubbleTea = bubbleTea;
  }

  public boolean isLarge() {
    return isLarge;
  }

  public void setLarge(boolean large) {
    isLarge = large;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    int totalPrice = price + (5 * bubbleTea.getToppings().size());

    if (isLarge) {
      totalPrice += 20;
    }
    this.price = totalPrice;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
