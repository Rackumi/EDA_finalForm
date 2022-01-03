package items.complejos;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplexNumberTest {

    public ComplexNumberTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }


    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void realPartTest() {
        ComplexNumber cn = new ComplexNumber(2.3,5);
        Assertions.assertEquals(2.3, cn.realPart(), "Parte real.");
    }

    @Test
    public void imaginaryPartTest() {
        ComplexNumber cn = new ComplexNumber(4.2,9.1);
        Assertions.assertEquals(9.1, cn.imaginaryPart(), "Parte imaginaria.");
    }

    @Test
    public void addTest() {
        ComplexNumber cn = new ComplexNumber(3,-4);
        Assertions.assertEquals(new ComplexNumber(5,3), cn.add(new ComplexNumber(2,7)), "Suma");
    }

    @Test
    public void subtractTest() {
        ComplexNumber cn = new ComplexNumber(9,5);
        Assertions.assertEquals(new ComplexNumber(5,-2), cn.subtract(new ComplexNumber(4,7)), "Resta");
    }

    @Test
    public void multiplyTest() {
        ComplexNumber cn = new ComplexNumber(5, 6);
        Assertions.assertEquals(new ComplexNumber(3, 28), cn.multiply(new ComplexNumber(3,2)), "Multiplicacion");
    }

    @Test
    public void divisionTest() {
        ComplexNumber cn = new ComplexNumber(13, 1);
        Assertions.assertEquals(new ComplexNumber(1, 4), cn.division(new ComplexNumber(1, -3)), "Division");
    }

    @Test
    public void conjugateTest() {
        ComplexNumber cn = new ComplexNumber(8, -2);
        ComplexNumber cc = cn.conjugate();
        Assertions.assertEquals(cn.realPart(), cc.realPart(),"Conjugado real.");
        Assertions.assertEquals(-cn.imaginaryPart(), cc.imaginaryPart(),"Conjugado imaginario.");
    }

    @Test
    public void moduleTest() {
        ComplexNumber cn = new ComplexNumber(4,-3);
        Assertions.assertEquals(5, cn.module(), "Modulo");
    }

}