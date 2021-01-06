package pl.bienkowskaAgata.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

  /*  @ParameterizedTest
    @CsvSource({"Kolorowa, 12", "Biała, 1"})
    void givenAddressShouldNotBeEmptyAndHaveProperNames ( String street, String number){
        assertThat(street).isNotNull();
        assertThat(street).contains("a");
        assertThat(number).isNotNull();
        }
*/
  @ParameterizedTest
  @CsvFileSource(resources = "/addresses.csv")
  void addressFromFailShouldNotBeEmptyAndHaveProperNames ( String street, String number){
      assertThat(street).isNotNull();
      assertThat(street).contains("a");
      assertThat(number).isNotNull();
  }

}