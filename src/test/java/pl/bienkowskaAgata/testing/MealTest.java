package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

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

    @TestFactory
    Collection<DynamicTest> whatShouldBeCalculateMealPrice(){
       Order order = new Order();
       order.addMealToOrder(new Meal(12, "salad", 3));
       order.addMealToOrder(new Meal(5, "sandwich", 5));
       order.addMealToOrder(new Meal(20, "pizza", 1));

       Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < order.getMeals().size() ; i++) {
            int price = order.getMeals().get(i).getPrice();
            int quantity = order.getMeals().get(i).getQuantity();

            Executable executable = ()->{
                assertThat(calculatePrice(price, quantity)).isLessThan(68);
            };
            String name = "Test name: " +i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);

            dynamicTests.add(dynamicTest);
        }
       return dynamicTests;
    }

    private int calculatePrice (int price, int quantity){
        return price * quantity;
    }
}