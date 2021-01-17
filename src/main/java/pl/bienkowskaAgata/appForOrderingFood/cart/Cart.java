package pl.bienkowskaAgata.appForOrderingFood.cart;

import pl.bienkowskaAgata.appForOrderingFood.Meal;
import pl.bienkowskaAgata.appForOrderingFood.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrderToBasket(Order order) {
        this.orders.add(order);
    }

    void cleanBasket (){
        this.orders.clear();
    }

    public void simulateLargeOrder (){
        for (int i = 0; i < 1000; i++) {
            Meal meal = new Meal( i%10, "Hamburger no" + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToBasket(order);
        }
        System.out.println("Basket size: " + orders.size());
        cleanBasket();
    }
}
