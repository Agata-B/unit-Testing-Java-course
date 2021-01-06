package pl.bienkowskaAgata.testing;

import org.mockito.internal.matchers.Or;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    void addOrderToBasket (Order order) {
        this.orders.add(order);
    }

    void cleanBasket (){
        this.orders.clear();
    }

    void simulateLargeOrder (){
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
