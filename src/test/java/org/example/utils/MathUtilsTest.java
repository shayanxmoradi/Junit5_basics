package org.example.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//giving order to running codes
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//just creates one obj
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@DisplayName("testing mathiutil")
class MathUtilsTest {
    MathUtils mathUtilsUnserTest;

    @BeforeAll
    static void setUp() {
        System.out.println("hi im begginging with JDBC");
    }

    @BeforeEach
    void setUpEach() {
        mathUtilsUnserTest = new MathUtils();

    }

    @Test
    @Order(1)
    @DisplayName("just run with mac")
    @EnabledOnOs(OS.MAC)
    @EnabledOnJre(JRE.JAVA_22)
    @EnabledIf("runAddWhenTrue")
    void add() {
        //ex. make it false when server is off
        assumeTrue(true);
        int expected = 3;
        int actuallRes = mathUtilsUnserTest.add(1, 2);
        assertEquals(expected, actuallRes);

    }

    boolean runAddWhenTrue() {
        return true;
    }
//teste
    //

    @Test
    @Order(2)
    @DisplayName("shuold test divide ,2 numbs ")
    void testDivide() {

        assertEquals(2.0, mathUtilsUnserTest.divide(4.0, 2.0), "4 / 2 should equal 2");
        assertEquals(2.5, mathUtilsUnserTest.divide(5.0, 2.0), "5 / 2 should equal 2.5");
        assertThrows(ArithmeticException.class, () -> mathUtilsUnserTest.divide(1.0, 0.0), "Division by zero should throw ArithmeticException");

        //doing togher
        assertAll(
                () -> assertEquals(2.0, mathUtilsUnserTest.divide(4.0, 2.0), "4 / 2 should equal 2"),
                () -> assertEquals(2.5, mathUtilsUnserTest.divide(5.0, 2.0), "5 / 2 should equal 2.5")
        );

    }


    @Test
    @DisplayName("shuold test sub ,2 numbs")
    void mineus() {
        int actRes = mathUtilsUnserTest.minus(3, 2);
        int expected = 1;
        assertEquals(expected, actRes);
    }

    @AfterAll
    @Disabled
    static void closeIt() {
        System.out.println("Chaooo");
    }

}
