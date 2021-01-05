package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class  MealTest {

    @Test
    void shouldReturnDiscountedPrice(){
        //given
        Meal meal = new Meal(36);
        //when
        int discountedPrice = meal.getDiscountedPrice(10);
        //then
        assertEquals(26, discountedPrice);
        assertThat(discountedPrice).isEqualTo(26); //assertJ
    }

    @Test
    void referenceToTheSameObjectShouldBeEquals (){
        //given
        Meal meal1 = new Meal(47);
         Meal meal2 = meal1;

        //then
        assertSame(meal1, meal2);
    }

    @Test
    void referenceToDifferentObjectShouldBeNotEquals (){
        //given
        Meal meal1 = new Meal(47);
        Meal meal2 = new Meal(32);

        //then
        assertNotSame(meal1, meal2);
    }

    @Test
    void twoMealsShouldBeTheSameWhenPriceAndNameAreTheSame (){
        //given
        Meal meal = new Meal(28, "Pizza");
        Meal meal1 = new Meal(28, "Pizza");

        //then
        assertEquals(meal, meal1);
    }

    @Test
    void exceptionShouldBeThrowIfDiscountIsHigherThanPrice() {
        //given
         Meal meal = new Meal(30, "spaghetti");
        //when

        //then
        assertThrows(IllegalArgumentException.class, ()->meal.getDiscountedPrice(35));
     }
}