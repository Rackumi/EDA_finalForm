package test.graphs.graphAlgorithms;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import structures.graphs.graphAlgorithms.Recorridos;
import structures.graphs.graph.ELGraph;
import structures.graphs.Edge;
import structures.graphs.Vertex;

import static org.junit.Assert.*;

/**
 * @author Rackumi
 */
public class RecorridosTest {

    public RecorridosTest() {
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

    /**
     * Test of getPath method, of class Recorridos.
     */
    @Test
    public void testDepthTravel() {
        System.out.println("depthTravelTest");
        ELGraph<String, String> g = new ELGraph<>();

        Vertex<String> vA = g.insertVertex("A");
        Vertex<String> vB = g.insertVertex("B");
        Vertex<String> vC = g.insertVertex("C");
        Vertex<String> vD = g.insertVertex("D");
        Vertex<String> vE = g.insertVertex("E");
        Vertex<String> vF = g.insertVertex("F");

        Edge<String> AB = g.insertEdge(vA, vB, "AB");
        Edge<String> BD = g.insertEdge(vB, vD, "BD");
        Edge<String> DC = g.insertEdge(vD, vC, "DC");
        Edge<String> DF = g.insertEdge(vD, vF, "DF");
        Edge<String> FE = g.insertEdge(vF, vE, "FE");

        Recorridos<String, String> algorithm = new Recorridos<>();
        List <Vertex<String>> depth = algorithm.depthTravel(g, vA);

        String stringPath = "";
        for (Vertex<String> e : depth) {
            if (!stringPath.equals(""))
                stringPath += ",";
            stringPath += e.getElement();
        }
        System.out.println(stringPath);

        String expectedPath1 = "A,B,D,C,F,E";
        String expectedPath2 = "A,B,D,F,E,C";

        final boolean list1Match = stringPath.equals(expectedPath1);
        final boolean list2Match = stringPath.equals(expectedPath2);

        assertTrue(list1Match || list2Match);
    }

    /**
     * Test of getPath method, of class Recorridos.
     */
    @Test
    public void testWidthTravel() {
        System.out.println("widthTravelTest");
        ELGraph<String, String> g = new ELGraph<>();

        Vertex<String> vA = g.insertVertex("A");
        Vertex<String> vB = g.insertVertex("B");
        Vertex<String> vC = g.insertVertex("C");
        Vertex<String> vD = g.insertVertex("D");
        Vertex<String> vE = g.insertVertex("E");
        Vertex<String> vF = g.insertVertex("F");
        Vertex<String> vG = g.insertVertex("G");

        Edge<String> AB = g.insertEdge(vA, vB, "AB");
        Edge<String> BD = g.insertEdge(vB, vD, "BD");
        Edge<String> DC = g.insertEdge(vD, vC, "DC");
        Edge<String> DF = g.insertEdge(vD, vF, "DF");
        Edge<String> FE = g.insertEdge(vF, vE, "FE");
        Edge<String> CG = g.insertEdge(vC, vG, "CG");

        Recorridos<String, String> algorithm = new Recorridos<>();
        List<Vertex<String>> depth = algorithm.widthTravel(g, vA);

        String stringPath = "";
        for (Vertex<String> e : depth) {
            if (!stringPath.equals(""))
                stringPath += ",";
            stringPath += e.getElement();
        }
        System.out.println(stringPath);

        String expectedPath1 = "A,B,D,C,F,G,E";
        String expectedPath2 = "A,B,D,F,C,E,G";

        final boolean list1Match = stringPath.equals(expectedPath1);
        final boolean list2Match = stringPath.equals(expectedPath2);

        assertTrue(list1Match || list2Match);
    }

    /**
     * Test of getPath method, of class Recorridos.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        ELGraph<String, String> g = new ELGraph<>();

        Vertex<String> vA = g.insertVertex("A");
        Vertex<String> vB = g.insertVertex("B");
        Vertex<String> vC = g.insertVertex("C");
        Vertex<String> cD = g.insertVertex("D");
        Vertex<String> vE = g.insertVertex("E");
        Vertex<String> vF = g.insertVertex("F");
        Vertex<String> vG = g.insertVertex("G");
        Vertex<String> vH = g.insertVertex("H");
        Vertex<String> vI = g.insertVertex("I");
        Vertex<String> vJ = g.insertVertex("J");
        Vertex<String> vK = g.insertVertex("K");
        Vertex<String> vL = g.insertVertex("L");
        Vertex<String> vM = g.insertVertex("M");
        Vertex<String> vN = g.insertVertex("N");
        Vertex<String> vO = g.insertVertex("O");
        Vertex<String> vP = g.insertVertex("P");

        Edge<String> AE = g.insertEdge(vA, vE, "AE");
        Edge<String> AF = g.insertEdge(vA, vF, "AF");
        Edge<String> AB = g.insertEdge(vA, vB, "AB");

        Edge<String> BC = g.insertEdge(vB, vC, "BC");

        Edge<String> CD = g.insertEdge(vC, cD, "CD");

        Edge<String> DG = g.insertEdge(cD, vG, "DG");
        Edge<String> DH = g.insertEdge(cD, vH, "DH");

        Edge<String> EF = g.insertEdge(vE, vF, "EF");
        Edge<String> EI = g.insertEdge(vE, vI, "EI");

        Edge<String> FB = g.insertEdge(vF, vB, "FB");
        Edge<String> FI = g.insertEdge(vF, vI, "FI");

        Edge<String> GL = g.insertEdge(vG, vL, "GL");
        Edge<String> GJ = g.insertEdge(vG, vJ, "GJ");
        Edge<String> GK = g.insertEdge(vG, vK, "GK");

        Edge<String> HL = g.insertEdge(vH, vL, "HL");

        Edge<String> IJ = g.insertEdge(vI, vJ, "IJ");
        Edge<String> IM = g.insertEdge(vI, vM, "IM");
        Edge<String> IN = g.insertEdge(vI, vN, "IN");

        Edge<String> JK = g.insertEdge(vJ, vK, "JK");

        Edge<String> KO = g.insertEdge(vK, vO, "KO");
        Edge<String> KN = g.insertEdge(vK, vN, "KN");

        Edge<String> LP = g.insertEdge(vL, vP, "LP");

        Edge<String> MN = g.insertEdge(vM, vN, "MN");

        Edge<String> OP = g.insertEdge(vO, vP, "OP");

        Recorridos<String, String> algorithm = new Recorridos<>();
        List <Edge<String>> path = algorithm.getPath(g, vA, vP);
        
        String stringPath = "";
        for (Edge<String> e : path) {
            if (!stringPath.equals("")) 
                stringPath += ",";
            stringPath += e.getElement();
        }
        System.out.println(stringPath);
        
        String expectedPath1 = "AE,EI,IN,KN,KO,OP";
        String expectedPath2 = "AF,FI,IN,KN,KO,OP";
        String expectedPath3 = "AE,EI,IJ,JK,KO,OP";
        String expectedPath4 = "AF,FI,IJ,JK,KO,OP";
        String expectedPath5 = "AB,BC,CD,DH,HL,LP";
        String expectedPath6 = "AB,BC,CD,DG,GL,LP";
        String expectedPath7 = "AE,EI,IJ,GJ,GL,LP";
        String expectedPath8 = "AF,FI,IJ,GJ,GL,LP";

        final boolean list1Match = stringPath.equals(expectedPath1);
        final boolean list2Match = stringPath.equals(expectedPath2);
        final boolean list3Match = stringPath.equals(expectedPath3);
        final boolean list4Match = stringPath.equals(expectedPath4);
        final boolean list5Match = stringPath.equals(expectedPath5);
        final boolean list6Match = stringPath.equals(expectedPath6);
        final boolean list7Match = stringPath.equals(expectedPath7);
        final boolean list8Match = stringPath.equals(expectedPath8);
        
        assertTrue(list1Match || list2Match || list3Match || list4Match || list5Match || list6Match || list7Match || list8Match);
    }

}