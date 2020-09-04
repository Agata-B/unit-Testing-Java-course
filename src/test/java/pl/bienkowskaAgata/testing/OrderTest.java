package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {
        //given
        Order order = new Order();

        //then
        assertThat(order.getMeals()).isEmpty();
        assertThat(order.getMeals()).hasSize(0);
    }

    @Test
    void addingMealToTheOrderShouldIncreaseOrderSize() {
        //given
        Meal meal = new Meal(28, "Pizza");
        Order order = new Order();
        // when
        order.addMealToOrder(meal);
        //then
        assertThat(order.getMeals()).hasSize(1);
        assertThat(order.getMeals()).contains(meal);
    }

    @Test
    void removingMealToTheOrderShouldIncreaseOrderSize() {
        //given
        Meal meal = new Meal(28, "Pizza");
        Order order = new Order();
        // when
        order.addMealToOrder(meal);
        order.removeMealToOrder(meal);
        //then
        assertThat(order.getMeals()).isEmpty();
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThenToOrder(){
        //given
        Meal meal = new Meal(28, "Pizza");
        Meal meal1 = new Meal(8, "Sandwich");
        Order order = new Order();
        // when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal1);
        //then
        assertThat(order.getMeals()).contains(meal, meal1);
    }

    @Test
    void testIfTwoMealsListAreTheSame(){
        //given
        Meal meal = new Meal(28, "Pizza");
        Meal meal1 = new Meal(8, "Sandwich");
        Meal meal2 = new Meal(18, "Kebab");

        List<Meal> meals1 = Arrays.asList(meal,meal1, meal2);
        List<Meal> meals2 = Arrays.asList(meal,meal1, meal2);

        //then
        assertThat(meals1).isEqualTo(meals2);
    }
}