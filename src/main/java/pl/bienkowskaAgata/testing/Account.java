package pl.bienkowskaAgata.testing;

public class Account {

    private boolean activeAccount;
    private Address defaultDeliveryAddress;
    private String email;

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

    public void setEmail(String email) {
        if (email.matches("^[A-Za-z0-9._%+-]+0[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            this.email = email;
        } else  {
            throw new IllegalArgumentException("wrong email format");
        }
    }
}
