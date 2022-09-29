package kitchenpos.products.tobe.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("상품이름 테스트")
class DisplayedNameTest {

  @DisplayName("상품이름을 생성할 수 있다.")
  @Test
  void createName() {
    DisplayedName name = DisplayedName.from("후라이드 치킨");
    Assertions.assertThat(name).isEqualTo(DisplayedName.from("후라이드 치킨"));
  }

}