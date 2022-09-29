package kitchenpos.products.tobe.domain;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Embedded;

public class Product {

  private UUID id;

  private DisplayedName name;

  private Price price;

  public Product(UUID id, DisplayedName name, Price price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public UUID getId() {
    return id;
  }

  public DisplayedName getName() {
    return name;
  }

  public Price getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
