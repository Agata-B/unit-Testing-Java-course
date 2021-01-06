package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;


class BasketTest {

    @Test
    @DisplayName("Basket is able to process 1000 orders in 100ms.")
    void simulateLargeOrder() {
        //given
         Basket basket = new Basket();
        //when
        //then
        assertTimeout(Duration.ofMillis(100 ), basket::simulateLargeOrder);
     }

     @Test
     void basketShouldNotBeEmptyAfterAddingOrderToBasket() {
         //given
         Order order = new Order();
         Basket basket = new Basket();
         //when
         basket.addOrderToBasket(order);
         //then
       assertThat(basket.getOrders(), allOf(
             notNullValue(),
           hasSize(0),
           is(not(emptyCollectionOf(Order.class)))
       ));
      }
}