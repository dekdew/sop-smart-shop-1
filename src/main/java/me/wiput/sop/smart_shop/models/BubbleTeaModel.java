package me.wiput.sop.smart_shop.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bubbletea")
public class BubbleTeaModel {

  @Id
  @GeneratedValue(generator = "bubbletea_generator")
  @SequenceGenerator(
      name = "bubbletea_generator",
      sequenceName = "bubbletea_sequence",
      initialValue = 1,
      allocationSize = 1
  )
  public Long id;

  public double sugarLevel;

  @Column(name = "toppings")
  @ElementCollection(targetClass = String.class)
  public List<String> toppings;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getSugarLevel() {
    return sugarLevel;
  }

  public void setSugarLevel(double sugarLevel) {
    this.sugarLevel = sugarLevel;
  }

  public List<String> getToppings() {
    return toppings;
  }

  public void setToppings(List<String> toppings) {
    this.toppings = toppings;
  }
}
