package pl.bienkowskaAgata.testing;

import java.util.Objects;

public class Meal {

    private int price;
    private String nameMeal;

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String nameMeal) {
        this.price = price;
        this.nameMeal = nameMeal;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(int discount) {
        return this.price - discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return price == meal.price &&
                Objects.equals(nameMeal, meal.nameMeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, nameMeal);
    }
}
