import org.testng.*;
import org.testng.annotations.*;

public class CalculatorTests {

    private static Calculator calculator;

    @BeforeTest
    public static void beforeClass() {
        System.out.println("Before CalculatorTest.class");
    }

    @AfterTest
    public static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @BeforeSuite
    public static void initTest() {
        calculator = new Calculator();
    }

    @AfterSuite
    public static void afterTest() {
        calculator = null;
    }

    /*@Test
    public void testSlojenie(int arg1, int arg2, int exp) throws Exception {
        Assert.assertEquals(exp, Calculator.sum(arg1, arg2));
    }*/

    @Test(dataProvider = "data-provider")
    public void testSlojenie (int arg1, int arg2, int result) {
        Assert.assertEquals(result, Calculator.sum(arg1, arg2));
    }
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
    }


    @Test
    public void testVichetanie() throws Exception {
        Assert.assertEquals(7, Calculator.sub(10, 3));
    }

    @Test
    public void testUmnojenie() throws Exception {
        Assert.assertEquals(30, Calculator.multi(6, 5));
    }

    @Test
    public void testDelenie() throws Exception {
        Assert.assertEquals(17, Calculator.div(34, 2));
    }

}