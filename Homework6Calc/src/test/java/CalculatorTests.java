import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import org.junit.runners.*;

import java.util.stream.*;
//import org.junit.jupiter.api.*;


@Tag("AllTests")
public class CalculatorTests {

    private static Calculator calculator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @BeforeAll
    public static void initTest() {
        calculator = new Calculator();
    }

    @AfterAll
    public static void afterTest() {
        calculator = null;
    }
    @DisplayName("SUMMA")
    @ParameterizedTest
    @Tag("sum")
    //@CsvSource({"6,6,12", "3,4,7"})
    @MethodSource
    public void testSlojenie(int arg1, int arg2, int exp) throws Exception {
        Assertions.assertEquals(exp, Calculator.sum(arg1, arg2));
    }

    private static Stream<Arguments> testSlojenie() {
        return Stream.of(
                Arguments.of(6,6,12),
                Arguments.of(3,4,7)
        );
    }

    @DisplayName("SUB")
    @Test
    @Tag("sub")
    public void testVichetanie() throws Exception {
        Assertions.assertEquals(9, Calculator.sub(10, 3));
    }

    @Test
    @Tag("multi")
    public void testUmnojenie() throws Exception {
        Assertions.assertEquals(30, Calculator.multi(6, 5));
    }

    @Test
    @Tag("div")
    public void testDelenie() throws Exception {
        Assertions.assertEquals(17, Calculator.div(34, 2));
    }

}