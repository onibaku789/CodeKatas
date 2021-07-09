package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

  private final List<ProductQuantity> items = new ArrayList<>();
  private final Map<Product, Double> productQuantities = new HashMap<>();

  public List<ProductQuantity> getItems() {
    return new ArrayList<>(items);
  }

  public void addItem(Product product) {
    addItemQuantity(product, 1.0);
  }

  public Map<Product, Double> productQuantities() {
    return productQuantities;
  }

  public void addItemQuantity(Product product, double quantity) {
  /*  Optional<ProductQuantity> productQuantityOptional = items.stream().filter(productQuantity -> productQuantity.getProduct().equals(product))
      .findAny();
    if (productQuantityOptional.isPresent()) {
      productQuantityOptional.get().addQuantity(quantity);
    }
    else {
      items.add(new ProductQuantity(product, quantity));
    }*/
    items.add(new ProductQuantity(product, quantity));
    if (productQuantities.containsKey(product)) {
      productQuantities.put(product, productQuantities.get(product) + quantity);
    } else {
      productQuantities.put(product, quantity);
    }
  }

}
