package pl.bienkowskaAgata.testing;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public List<Meal> meals = new ArrayList<>();

    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    public void removeMealToOrder(Meal meal) {
        this.meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    void cancel(){
        this.meals.clear();
    }

    int totalPrize (){
        int sum = 0;
       sum =  this.meals.stream().mapToInt(meal ->meal.getPrice()).sum();
       if (sum<0) {
           throw new IllegalStateException("Price limit exceeded");
       } else {
           return sum;
       }
    }

    @Override
    public String toString() {
        return "Order: " +
                "meals " + meals;
    }

}
