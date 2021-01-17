package pl.bienkowskaAgata.appForOrderingFood;

import java.util.Objects;

public class Meal {

    private int price;
    private String nameMeal;
    private int quantity;

    public Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String nameMeal) {
        this.price = price;
        this.nameMeal = nameMeal;
    }

    public Meal(int price, String nameMeal, int quantity) {
        this.price = price;
        this.nameMeal = nameMeal;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {return quantity; }

    public int getDiscountedPrice(int discount) {
        if(discount>this.price){
            throw new IllegalArgumentException("The discount is higher than the basic price.");
        }

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

    @Override
    public String toString() {
        return "Meal: " +
                "price " + price +
                ", nameMeal " + nameMeal;
    }
}
