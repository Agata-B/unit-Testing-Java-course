package pl.bienkowskaAgata.appForOrderingFood.account;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Test
    void getAllActiveAccount() {
        //given
        List<Account> accounts = prepareAccountData();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.getAllAccounts()).thenReturn(accounts);
        //when
        List<Account> accountList = accountService.getAllActiveAccounts();
        //then
        assertThat(accountList, hasSize(2));
    }

    @Test
    void getNoActiveAccount() {
        //given
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.getAllAccounts()).thenReturn(Arrays.asList());
        //when
        List<Account> accountList = accountService.getAllActiveAccounts();
        //then
        assertThat(accountList, hasSize(0));
    }
    private List<Account> prepareAccountData() {

        Address address1 = new Address("Kwiatowa", "33");
        Account account1 = new Account(address1);

        Account account2 = new Account();

        Address address2 = new Address("Kolorowa", "33");
        Account account3 = new Account(address2);

        return Arrays.asList(account1, account2, account3);
    }
}
