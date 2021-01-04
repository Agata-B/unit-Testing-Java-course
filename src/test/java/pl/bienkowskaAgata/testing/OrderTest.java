package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

@Test
void mealListShouldBeEmptyAfterCreationOrder() {
    //given
    Order order = new Order();
    //when
    //then
    assertThat(order.getMeals().isEmpty());
 }
 
 @Test
 void addingMealToOrderShouldIncreaseOrderSize() {
     //given
     Meal meal = new Meal(20, "salad");
     Order order = new Order();
     //when
     order.addMealToOrder(meal);
     //then
     assertThat(order.getMeals()).hasSize(1);
  }

  @Test
  void removingMealFromOrderShouldDecreaseOrderSize() {
      //given
       Meal meal = new Meal(20, "salad");
       Meal meal2 = new Meal(4, "sandwich");
       Order order = new Order();
      //when
      order.addMealToOrder(meal);
      order.addMealToOrder(meal2);
      order.removeMealToOrder(meal);
      //then
      assertThat(order.getMeals()).doesNotContain(meal);
   }
}