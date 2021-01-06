package pl.bienkowskaAgata.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setUp () throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("NEW ORDER ");
    }

    @Test
    void backUpOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(25, "pasta");
        Order order = new Order();
        order.addMealToOrder(meal);
        //when
        orderBackup.backUpOrder(order);
        //then
        System.out.println(order.toString());
     }
    @AfterAll
    static  void close () throws IOException {
        orderBackup.closeFile();
    }

}