package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.Test;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class  AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
        //given + when
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActiveAccount());
        // hamcrest assertThat(newAccount.isActiveAccount(), equalTo(false));
        assertThat(newAccount.isActiveAccount()).isFalse(); //assertJ
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActiveAccount());
        //hamcrest assertThat(newAccount.isActiveAccount(), is(true));
    }

    @Test
    void newCreatedAccountShouldNotHaveDefaultDeliveryAddress() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);
        //hamcrest assertThat(address, nullValue());
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Kolorowa", "12A");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();
        //then
        assertNotNull(defaultAddress);
    }
}