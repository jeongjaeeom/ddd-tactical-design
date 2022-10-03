package kitchenpos.menus.tobe.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("메뉴 테스트")
class MenuTest {

  @DisplayName("1개 이상의 등록된 상품으로 메뉴를 등록할 수 있다.")
  @Test
  void create() {
    MenuGroup menuGroup = createMenuGroup("점심특선");
    Menu menu = createMenu(
        "후라이드+후라이드",
        19_000L,
        true,
        menuGroup,
        List.of(createMenuProduct(UUID.randomUUID(), 12_000L, 2))
    );

    assertThat(menu).isNotNull();
    assertAll(
        () -> assertThat(menu.getId()).isNotNull(),
        () -> assertThat(menu.getName()).isEqualTo(DisplayedName.from("후라이드+후라이드")),
        () -> assertThat(menu.getPrice()).isEqualTo(Price.from(19_000L)),
        () -> assertThat(menu.getMenuGroup().getId()).isEqualTo(menuGroup.getId()),
        () -> assertThat(menu.getDisplayState()).isEqualTo(DisplayState.show()),
        () -> assertThat(menu.getMenuProducts()).hasSize(1)
    );
  }

  @DisplayName("메뉴에 속한 상품의 수량은 0개 이상이어야 한다.")
  @Test
  void createMenu_NotValidQuantity() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> createMenu(
            "후라이드+후라이드",
            19_000L,
            true,
            createMenuGroup("점심특선"),
            List.of(createMenuProduct(UUID.randomUUID(), 12_000L, -1))
        ));
  }

  @DisplayName("메뉴의 가격이 올바르지 않으면 등록할 수 없다.")
  @ValueSource(strings = "-1")
  @ParameterizedTest
  void createMenu_NotValidPrice(final Long price) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> createMenu(
            "후라이드+후라이드",
            price,
            true,
            createMenuGroup("점심특선"),
            List.of(createMenuProduct(UUID.randomUUID(), 12_000L, 2))
        ));
  }



  private static MenuGroup createMenuGroup(String name) {
    return new MenuGroup(UUID.randomUUID(), DisplayedName.from(name));
  }

  private static Menu createMenu(
      String name,
      long price,
      boolean displayed,
      MenuGroup menuGroup,
      List<MenuProduct> menuProducts
  ) {
    return new Menu(
        UUID.randomUUID(),
        DisplayedName.from(name),
        Price.from(price),
        DisplayState.from(displayed),
        menuGroup,
        menuProducts
    );
  }

  private static MenuProduct createMenuProduct(
      UUID productId,
      long price,
      long quantity
  ) {
    return new MenuProduct(productId, Price.from(price), Quantity.from(quantity));
  }

}