package pl.bienkowskaAgata.appForOrderingFood.order;

import pl.bienkowskaAgata.appForOrderingFood.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderStatus orderStatus;
    public List<Meal> meals = new ArrayList<>();

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void changeOrderStatus(OrderStatus orderStatus ) {
        this.orderStatus = orderStatus;
    }
    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    public void removeMealToOrder(Meal meal) {
        this.meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void cancel(){
        this.meals.clear();
    }

    public int totalPrize (){
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
