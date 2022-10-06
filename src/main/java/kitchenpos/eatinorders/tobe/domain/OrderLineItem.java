package kitchenpos.eatinorders.tobe.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderLineItem {

  private final UUID menuId;

  private final BigDecimal price;

  private final long quantity;

  public OrderLineItem(UUID menuId, BigDecimal price, long quantity) {
    this.menuId = menuId;
    this.price = price;
    this.quantity = quantity;
  }
}