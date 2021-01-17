package pl.bienkowskaAgata.appForOrderingFood.cart;

import org.junit.jupiter.api.Test;
import pl.bienkowskaAgata.appForOrderingFood.order.Order;
import pl.bienkowskaAgata.appForOrderingFood.order.OrderStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class CartServiceTest {

    @Test
    void processCartShouldSendToPrepare() {
        //given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToBasket(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(cart)).willReturn(true);

        //when
        Cart resultCart = cartService.processCart(cart);

        //then
        verify(cartHandler).sendToPrepare(cart);
        then(cartHandler).should().sendToPrepare(cart);

        assertThat(resultCart.getOrders()).hasSize(1);
        assertThat(resultCart.getOrders().get(0).getOrderStatus()).isEqualTo(OrderStatus.PREPARING);
    }

    @Test
    void processCartShouldNotSendToPrepare() {
        //given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToBasket(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(cart)).willReturn(false);

        //when
        Cart resultCart = cartService.processCart(cart);

        //then
       // verify(cartHandler, never()).sendToPrepare(cart);
        then(cartHandler).should(never()).sendToPrepare(cart);
    }

    @Test
    void processCartShouldNotSendToPrepareWithArgumentMatcher() {
        //given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToBasket(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);

        given(cartHandler.canHandleCart(any(Cart.class))).willReturn(false);

        //when
        Cart resultCart = cartService.processCart(cart);

        //then
        then(cartHandler).should(never()).sendToPrepare(any(Cart.class));
    }

}