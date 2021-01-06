package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

     @ParameterizedTest
     @ValueSource(ints = {5, 10, 15, 18})
    void mealPriceShouldBeLowerThan20(int price){
         assertThat(price).isLessThan(20);
     }

     @ParameterizedTest
     @MethodSource("createMealWithNameAndPrice")
     void mealsShouldBeCorrectNameAndPrice(String name, int price){
        assertThat(name).contains("pizza");
        assertThat(price).isGreaterThanOrEqualTo(15);
     }

     private static Stream<Arguments> createMealWithNameAndPrice(){
        return Stream.of(
                Arguments.of("pizza", 15),
                Arguments.of("hamburger", 8)
        );
     }

     @ParameterizedTest
     @MethodSource("createCakeNames")
     void cakeNameShouldEndWithCake (String nameCake) {
        assertThat(nameCake).isNotNull();
        assertThat(nameCake).endsWith("cake");
     }

     private static Stream<String> createCakeNames (){
         List<String> cakeNames = Arrays.asList("cheesecake", "fruitcake", "cupcake");
         return cakeNames.stream();
    }
}