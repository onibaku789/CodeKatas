package dojo.supermarket.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Receipt {
  private final List<ReceiptItem> items = new ArrayList<>();
  private final List<Discount> discounts = new ArrayList<>();

  public Double getTotalPrice() {
    return getTotalPriceFormItems() + getTotalDiscountsFromItem();
  }

  private double getTotalDiscountsFromItem() {
    return discounts.stream().mapToDouble(Discount::getDiscountAmount).sum();
  }

  private double getTotalPriceFormItems() {
    return items.stream().mapToDouble(ReceiptItem::getTotalPrice).sum();
  }

  public void addProduct(ReceiptItem receiptItem) {
    items.add(receiptItem);
  }

  public List<ReceiptItem> getItems() {
    return new ArrayList<>(this.items);
  }

  public void addDiscount(Discount discount) {
    this.discounts.add(discount);
  }

  public List<Discount> getDiscounts() {
    return discounts;
  }

  public void handleOffers(Map<Product, Offer> offers, SupermarketCatalog catalog, ShoppingCart shoppingCart) {
    for (Product p : shoppingCart.productQuantities().keySet()) {
      double quantity = shoppingCart.productQuantities().get(p);
      if (offers.containsKey(p)) {
        Offer offer = offers.get(p);
        double unitPrice = catalog.getUnitPrice(p);
        int quantityAsInt = (int) quantity;
        Discount discount = null;
        int x = 1;
        if (offer.offerType == SpecialOfferType.ThreeForTwo) {
          x = 3;
        } else if (offer.offerType == SpecialOfferType.TwoForAmount) {
          x = 2;
          if (quantityAsInt >= 2) {
            int intDivision = quantityAsInt / x;
            double pricePerUnit = offer.argument * intDivision;
            double theTotal = (quantityAsInt % 2) * unitPrice;
            double total = pricePerUnit + theTotal;
            double discountN = unitPrice * quantity - total;
            discount = new Discount(p, "2 for " + offer.argument, -discountN);
          }

        }
        if (offer.offerType == SpecialOfferType.FiveForAmount) {
          x = 5;
        }
        int numberOfXs = quantityAsInt / x;

        if (offer.offerType == SpecialOfferType.ThreeForTwo && quantityAsInt > 2) {
          double discountAmount = quantity * unitPrice - ((numberOfXs * 2 * unitPrice) + quantityAsInt % 3 * unitPrice);
          discount = new Discount(p, "3 for 2", -discountAmount);
        }
        if (offer.offerType == SpecialOfferType.TenPercentDiscount) {
          discount = new Discount(p, offer.argument + "% off", -quantity * unitPrice * offer.argument / 100.0);
        }
        if (offer.offerType == SpecialOfferType.FiveForAmount && quantityAsInt >= 5) {
          double discountTotal = unitPrice * quantity - (offer.argument * numberOfXs + quantityAsInt % 5 * unitPrice);
          discount = new Discount(p, x + " for " + offer.argument, -discountTotal);
        }
        if (discount != null)
          addDiscount(discount);
      }
    }
  }
}
