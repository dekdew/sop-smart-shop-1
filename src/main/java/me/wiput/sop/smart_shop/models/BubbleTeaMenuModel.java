package me.wiput.sop.smart_shop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "bubbletea_menu")
public class BubbleTeaMenuModel extends AuditModel {

  @Id
  @GeneratedValue(generator = "bubbleteamenu_generator")
  @SequenceGenerator(
      name = "bubbleteamenu_generator",
      sequenceName = "bubbleteamenu_sequence",
      initialValue = 1,
      allocationSize = 1
  )
  public Long id;

  @NotNull(message = "isLarge is required")
  public boolean isLarge;

  @NotNull(message = "price is required")
  @Min(0)
  public int price;

  @NotNull(message = "name is required")
  public String name;

  @OneToOne
  @Fetch(FetchMode.JOIN)
  public BubbleTeaModel bubbleTea;

  public void setLarge(boolean large) {
    isLarge = large;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBubbleTea(BubbleTeaModel bubbleTea) {
    this.bubbleTea = bubbleTea;
  }
}
