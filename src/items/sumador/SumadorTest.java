package items.sumador;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumadorTest {

    public SumadorTest(){

    }

    @BeforeClass
    public static void setUpClass(){

    }

    @AfterClass
    public static void tearDownClass(){

    }


    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    @Test
    public void hello(){
        Sumador s = new Sumador();
        int r = s.add(3,4);
        //if(r != 7) fail("La suma es incorrecta.");
        Assertions.assertEquals(7, r, "La suma es incorrecta.");
    }
}
