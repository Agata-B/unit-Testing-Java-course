package pl.bienkowskaAgata.testing;

public class Account {

    private boolean activeAccount;
    private Address defaultDeliveryAddress;

    public Account() {
        this.activeAccount = false;
    }

    public Account(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        if (defaultDeliveryAddress != null) {
            activate();
        } else  {
            this.activeAccount = false;
        }
    }

    public void activate (){
        this.activeAccount = true;
    }

    public boolean isActiveAccount() {
        return this.activeAccount;
    }

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }
}
