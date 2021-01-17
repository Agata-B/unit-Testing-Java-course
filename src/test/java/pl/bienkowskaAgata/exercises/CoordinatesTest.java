package pl.bienkowskaAgata.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesTest {

    @Test
    void copyShouldBeReturnNewObject() {
        //given
        Coordinates coordinates = new Coordinates(5, 6);
        //when
        Coordinates copy = Coordinates.copy(coordinates,5,4);
        //then
        assertThat(copy).isNotEqualTo(coordinates);
    }

    @Test
    void copyShouldBeReturnNewValueForXAndY() {
        //given
         Coordinates coordinates = new Coordinates( 5, 5 );
        //when
        Coordinates copy = Coordinates.copy(coordinates, 3, 5);
        //then
        assertThat(copy.getX()).isEqualTo(8);
        assertThat(copy.getY()).isEqualTo(10);
     }
}