package pl.bienkowskaAgata.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    private  Unit unit;

    @BeforeEach
    void initializationUnit (){unit = new Unit( new Coordinates(2,3), 10, 8);}

    @Test
    void moveShouldBeReturnNewCoordinates() {
        //given
        // when
        Coordinates move = unit.move(2,2);
        //then
        assertThat(move).isNotEqualTo(unit);
    }

    @Test
    void fuelingShouldNotExceedMaxFuelLimit() {
        //given
        //when
        unit.tankUp();
        //then
        assertThat(unit.getFuel()).isEqualTo(10);
     }

     @Test
     void unloadingAllCargoShouldReduceUnitLoadToZero() {
         //given

         Cargo cargo1 = new Cargo("C1",4 );
         Cargo cargo2 = new Cargo("C2",4 );

         unit.loadCargo(cargo1);
         unit.loadCargo(cargo2);
         //when
         unit.unloadAllCargo();
         //then
         assertEquals(0, unit.getLoad());
      }

      @Test
      void cargoCanNotExceedMaxWeightLimit() {
          //given

          Cargo cargo1 = new Cargo("C1",4 );
          Cargo cargo2 = new Cargo("C2",5 );

          //when
          unit.loadCargo(cargo1);
          //then
          assertThrows(IllegalStateException.class, ()->unit.loadCargo(cargo2));
       }
}