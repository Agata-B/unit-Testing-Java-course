package pl.bienkowskaAgata.appForOrderingFood.cart;

public interface CartHandler {

    boolean canHandleCart (Cart cart);

    void sendToPrepare (Cart cart);
}
