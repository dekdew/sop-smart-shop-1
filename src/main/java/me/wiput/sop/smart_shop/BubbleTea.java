package me.wiput.sop.smart_shop;

import java.util.ArrayList;
import me.wiput.sop.smart_shop.execptions.InvalidSugarLevel;
import me.wiput.sop.smart_shop.execptions.InvalidToppingException;


public class BubbleTea {

  public BubbleTea(double sugarLevel, int[] toppings) throws InvalidToppingException {
    this.sugarLevel = sugarLevel;
    this.setToppings(toppings);
  }

  private static final String[] allToppings = new String[]{
      "Classic Bubble",
      "Golden Bubble",
      "Coffee Jelly",
      "Black Jelly"
  };

  private double sugarLevel;

  private ArrayList<String> toppings;

  public double getSugarLevel() {
    return sugarLevel;
  }

  public void setSugarLevel(double sugarLevel) throws InvalidSugarLevel {
    if (sugarLevel >= 0 && sugarLevel <= 1) {
      this.sugarLevel = sugarLevel;
    } else {
      throw new InvalidSugarLevel();
    }
  }

  public ArrayList<String> getToppings() {
    return toppings;
  }

  public void setToppings(int[] toppings) throws InvalidToppingException {
    ArrayList<String> toppingsList = new ArrayList<String>();

    for (int topping : toppings) {
      if (topping >= allToppings.length) {
        throw new InvalidToppingException("Invalid Topping!");
      } else {
        toppingsList.add(allToppings[topping]);
      }
    }

    this.toppings = toppingsList;
  }
}
