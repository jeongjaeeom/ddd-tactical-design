package kitchenpos.products.tobe.domain;

import java.util.Objects;

public class DisplayedName {

  private final String name;

  public DisplayedName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DisplayedName that = (DisplayedName) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}