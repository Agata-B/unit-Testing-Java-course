package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    void simulateLargeOrder() {
        //given
         Basket basket = new Basket();
        //when
        //then
        assertTimeout(Duration.ofMillis(100), basket::simulateLargeOrder);
     }

}