package dojo.supermarket.model;

import java.util.HashMap;
import java.util.Map;

public class Teller {

  private final SupermarketCatalog catalog;
  private final Map<Product, Offer> offers = new HashMap<>();

  public Teller(SupermarketCatalog catalog) {
    this.catalog = catalog;
  }

  public void addSpecialOffer(SpecialOfferType offerType, Product product, double argument) {
    this.offers.put(product, new Offer(offerType, argument));
  }

  public Receipt checksOutArticlesFrom(ShoppingCart theCart) {
    Receipt receipt = new Receipt();
    for (ProductQuantity pq : theCart.getItems()) {
      Product p = pq.getProduct();
      double quantity = pq.getQuantity();
      double unitPrice = this.catalog.getUnitPrice(p);
      double price = quantity * unitPrice;
      receipt.addProduct(new ReceiptItem(p, quantity, unitPrice, price));
    }
    receipt.handleOffers(this.offers, this.catalog, theCart);

    return receipt;
  }

}
