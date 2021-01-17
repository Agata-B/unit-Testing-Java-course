package pl.bienkowskaAgata.appForOrderingFood.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.bienkowskaAgata.appForOrderingFood.order.Order;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;


class CartTest {

    @Test
    @DisplayName("Basket is able to process 1000 orders in 100ms.")
    void simulateLargeOrder() {
        //given
         Cart cart = new Cart();
        //when
        //then
        assertTimeout(Duration.ofMillis(100 ), cart::simulateLargeOrder);
     }

     @Test
     void basketShouldNotBeEmptyAfterAddingOrderToBasket() {
         //given
         Order order = new Order();
         Cart cart = new Cart();
         //when
         cart.addOrderToBasket(order);
         //then
       assertThat(cart.getOrders(), allOf(
             notNullValue(),
           is(not(emptyCollectionOf(Order.class)))
       ));
      }
}