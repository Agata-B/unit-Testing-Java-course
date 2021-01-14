package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void initializationOrder(){
        order = new Order();
    }

    @AfterEach
    void cleanUp(){
        order.cancel();
    }

    @Test
void mealListShouldBeEmptyAfterCreationOrder() {

    //then
    assertThat(order.getMeals().isEmpty());
 }

 @Tag("salad")
 @Test
 void addingMealToOrderShouldIncreaseOrderSize() {
     //given
     Meal meal = new Meal(20, "salad");
     //when
     order.addMealToOrder(meal);
     //then
     assertThat(order.getMeals()).hasSize(1);
  }

  @Tag("salad")
  @Test
  void removingMealFromOrderShouldDecreaseOrderSize() {
      //given
       Meal meal = new Meal(20, "salad");
       Meal meal2 = new Meal(4, "sandwich");
      //when
      order.addMealToOrder(meal);
      order.addMealToOrder(meal2);
      order.removeMealToOrder(meal);
      //then
      assertThat(order.getMeals()).doesNotContain(meal);
   }

   @Tag("salad")
   @Test
   void mealsShouldBeInTheOrderAfterAddingThemToOrder() {
       //given
       Meal meal = new Meal(20, "salad");
       Meal meal2 = new Meal(4, "sandwich");
       //when
       order.addMealToOrder(meal);
       order.addMealToOrder(meal2);
       //then
       assertThat(order.getMeals()).containsExactlyInAnyOrder(meal2, meal);
    }
    
}