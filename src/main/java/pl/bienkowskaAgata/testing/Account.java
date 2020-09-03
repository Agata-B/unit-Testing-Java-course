package pl.bienkowskaAgata.testing;

public class Account {

    private boolean activeAccount;

    public Account() {
        this.activeAccount = false;
    }

    public void activate (){
        this.activeAccount = true;
    }

    public boolean isActiveAccount() {
        return this.activeAccount;
    }
}
