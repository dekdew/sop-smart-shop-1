package me.wiput.sop.smart_shop.forms;

public class BubbleTeaMenuForm {
  public boolean isLarge;

  public int price;

  public String name;

  public long bubbleTeaId;

  public boolean getIsLarge() {
    return isLarge;
  }

  public void setLarge(boolean large) {
    isLarge = large;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getBubbleTeaId() {
    return bubbleTeaId;
  }

  public void setBubbleTeaId(long bubbleTeaId) {
    this.bubbleTeaId = bubbleTeaId;
  }
}
