package dojo.supermarket.model;

public class ProductQuantity {
  private final Product product;
  private double quantity;

  public ProductQuantity(Product product, double weight) {
    this.product = product;
    this.quantity = weight;
  }

  public Product getProduct() {
    return product;
  }

  public double getQuantity() {
    return quantity;
  }

  public void addQuantity(double toAdd) {
    quantity += toAdd;
  }
}
