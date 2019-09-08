package me.wiput.sop.smart_shop;

import java.util.List;
import javax.validation.Valid;
import me.wiput.sop.smart_shop.execptions.ResourceNotFoundException;
import me.wiput.sop.smart_shop.forms.BubbleTeaMenuForm;
import me.wiput.sop.smart_shop.models.BubbleTeaMenuModel;
import me.wiput.sop.smart_shop.models.BubbleTeaModel;
import me.wiput.sop.smart_shop.repository.BubbleTeaMenuRepository;
import me.wiput.sop.smart_shop.repository.BubbleTeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaAuditing
public class SmartShopApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmartShopApplication.class, args);
  }

  @Autowired
  private BubbleTeaMenuRepository bubbleTeaMenuRepository;

  @Autowired
  private BubbleTeaRepository bubbleTeaRepository;

  @RequestMapping("/")
  String index() {
    return "Hi!";
  }

  @GetMapping("/menus")
  public List<BubbleTeaMenuModel> viewBubbleTeaMenuList() {
    return bubbleTeaMenuRepository.findAll();
  }

  @PostMapping("/menu")
  public BubbleTeaMenuModel createBubbleTeaMenu(
      @Valid @RequestBody BubbleTeaMenuForm bubbleTeaMenuForm) {
    BubbleTeaMenuModel bubbleTeaMenuModel = new BubbleTeaMenuModel();

    bubbleTeaMenuModel.setName(bubbleTeaMenuForm.getName());
    bubbleTeaMenuModel.setLarge(bubbleTeaMenuForm.getIsLarge());
    bubbleTeaMenuModel.setPrice(bubbleTeaMenuForm.getPrice());

    BubbleTeaModel bubbleTea = bubbleTeaRepository.findById(bubbleTeaMenuForm.getBubbleTeaId())
        .orElseThrow(() -> new ResourceNotFoundException("Not found"));

    bubbleTeaMenuModel.setBubbleTea(bubbleTea);

    return bubbleTeaMenuRepository.save(bubbleTeaMenuModel);
  }

  @GetMapping("/menu/{id}")
  public BubbleTeaMenuModel getBubbleTeaMenu(@PathVariable long id) {
    return bubbleTeaMenuRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found"));
  }

  @PutMapping("/menu/{id}")
  public BubbleTeaMenuModel updateBubbleTeaMenu(@PathVariable("id") long id,
      @Valid @RequestBody BubbleTeaMenuForm bubbleTeaMenuForm) {
    return bubbleTeaMenuRepository.findById(id).map(bubbleTeaMenuEntity -> {
      bubbleTeaMenuEntity.setName(bubbleTeaMenuForm.getName());
      bubbleTeaMenuEntity.setLarge(bubbleTeaMenuForm.getIsLarge());
      bubbleTeaMenuEntity.setPrice(bubbleTeaMenuForm.getPrice());

      BubbleTeaModel bubbleTea = bubbleTeaRepository.findById(bubbleTeaMenuForm.getBubbleTeaId())
          .orElseThrow(() -> new ResourceNotFoundException("Not found Bubble Tea"));

      bubbleTeaMenuEntity.setBubbleTea(bubbleTea);

      return bubbleTeaMenuRepository.save(bubbleTeaMenuEntity);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found Bubble Tea Menu"));
  }


  @DeleteMapping("/menu/{id}")
  public ResponseEntity<?> deleteBubbleTeaMenu(@PathVariable("id") long id) {
    bubbleTeaMenuRepository.deleteById(id);

    return ResponseEntity.accepted().build();
  }

  @GetMapping("/bubbletea")
  public List<BubbleTeaModel> getBubbleTeas() {
    return bubbleTeaRepository.findAll();
  }

  @PostMapping("/bubbletea")
  public BubbleTeaModel createBubbleTea(@Valid @RequestBody BubbleTeaModel bubbleTea) {
    return bubbleTeaRepository.save(bubbleTea);
  }

  @GetMapping("/bubbletea/{id}")
  public BubbleTeaModel getBubbleTea(@PathVariable("id") long id) {
    return bubbleTeaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found"));
  }

  @DeleteMapping("/bubbletea/{id}")
  public ResponseEntity<?> deleteBubbleTea(@PathVariable("id") long id) {
    bubbleTeaRepository.deleteById(id);
    return ResponseEntity.accepted().build();
  }

  @PutMapping("/bubbletea/{id}")
  public BubbleTeaModel updateBubbleTea(@PathVariable("id") long id,
      @Valid @RequestBody BubbleTeaModel bubbleTea) {
    return bubbleTeaRepository.findById(id).map(bubbleTeaEntity -> {
      bubbleTeaEntity.setToppings(bubbleTea.getToppings());
      bubbleTeaEntity.setSugarLevel(bubbleTea.getSugarLevel());
      return bubbleTeaRepository.save(bubbleTeaEntity);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found"));
  }


}
