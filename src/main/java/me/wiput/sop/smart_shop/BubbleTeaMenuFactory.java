package me.wiput.sop.smart_shop;

import me.wiput.sop.smart_shop.execptions.InvalidToppingException;

public class BubbleTeaMenuFactory {

  private static BubbleTeaMenu[] BUBBLE_TEA_MENUS;

  static {
    try {
      BUBBLE_TEA_MENUS = new BubbleTeaMenu[]{
          new BubbleTeaMenu(false, 60, "Bubble Tea with Golden Bubble",
              new BubbleTea(0.5, new int[]{1})),
          new BubbleTeaMenu(true, 60, "Bubble Tea with Golden Bubble (Large)",
              new BubbleTea(0.5, new int[]{1})),
          new BubbleTeaMenu(false, 60, "Bubble Tea with Coffee Jelly",
              new BubbleTea(0.5, new int[]{3})),
          new BubbleTeaMenu(true, 60, "Bubble Tea with Coffee Jelly (Large)",
              new BubbleTea(0.5, new int[]{3})),
      };
    } catch (InvalidToppingException e) {
      e.printStackTrace();
    }
  }

  public static BubbleTeaMenu viewBubbleTeaMenu(int menu) {
    return (BubbleTeaMenu) BUBBLE_TEA_MENUS[menu];
  }

  public static BubbleTeaMenu[] viewBubbleTeaMenuList() {
    return BUBBLE_TEA_MENUS;
  }
}
