package pl.bienkowskaAgata.appForOrderingFood.account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;


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
    
    @Test
    void newAccountWithNotNullAddressShouldBeActive() {
        //given
        Address address = new Address("Miedziana", "13");
        //when
        Account account = new Account(address);
        //then
        assumingThat(address != null, ()-> {
            assertTrue(account.isActiveAccount());
        });
     }
     
     @Test
     void invalidEmailShouldThrowException() {
         //given
          Account account = new Account();
         //when

         //then
         assertThrows(IllegalArgumentException.class, ()->account.setEmail("wrong email"));
      }

      @Test
      void validEmailShouldBeSet() {
          //given
           Account account = new Account();
          //when
          account.setEmail("kontakt@test.pl");
          //then
          assertThat(account.getEmail()).isEqualTo("kontakt@test.pl");
       }
}