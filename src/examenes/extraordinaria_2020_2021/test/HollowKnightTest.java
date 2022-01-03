package examenes.extraordinaria_2020_2021.test;

import examenes.extraordinaria_2020_2021.Area;
import examenes.extraordinaria_2020_2021.HollowKnight;
import structures.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HollowKnightTest {

    private HollowKnight hollowKnight;
    private List<Position<Area>> areas;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        hollowKnight = new HollowKnight();
        hollowKnight.newItem("LlaveSimple");
        hollowKnight.newItem("MarcaDelRey");
        hollowKnight.newItem("HuevoPodrido");
        hollowKnight.newItem("SelloDeHallownest");
        hollowKnight.newItem("BendicionDeSalubra");
        hollowKnight.newItem("LlaveDelAmor");
        for (int i = 0; i < 3; i++) {
            hollowKnight.addItem("LlaveSimple");
        }
        for (int i = 0; i < 15; i++) {
            hollowKnight.addItem("HuevoPodrido");
        }
        hollowKnight.addItem("MarcaDelRey");
        hollowKnight.addItem("BendicionDeSalubra");
        areas = new ArrayList<>();
        areas.add(hollowKnight.addArea("Bocasucia", 3, 1));
        areas.add(hollowKnight.addArea("AcantiladosAulladores", 10, 3, areas.get(0)));
        areas.add(hollowKnight.addArea("SenderoVerde", 5, 2, areas.get(0)));
        areas.add(hollowKnight.addArea("CrucesOlvidados", 20, 4, areas.get(0)));
        areas.add(hollowKnight.addArea("JardinesDeLaReina", 7, 5, areas.get(2)));
        areas.add(hollowKnight.addArea("CanyonNublado", 6, 6, areas.get(3)));
        areas.add(hollowKnight.addArea("ParamosFungicos", 10, 8, areas.get(3)));
        areas.add(hollowKnight.addArea("CumbreDeCristal", 15, 10, areas.get(3)));
        areas.add(hollowKnight.addArea("TierrasDeReposo", 15, 3, areas.get(3)));
        areas.add(hollowKnight.addArea("NidoProfundo", 30, 9, areas.get(6)));
        areas.add(hollowKnight.addArea("CiudadDeLagrimas", 19, 2, areas.get(6)));
        areas.add(hollowKnight.addArea("CanalesReales", 12, 7, areas.get(10)));
        areas.add(hollowKnight.addArea("LimiteDelReino", 5, 7, areas.get(10)));
        areas.add(hollowKnight.addArea("CuencaAntigua", 100, 10, areas.get(11)));
        areas.add(hollowKnight.addArea("LaColmena", 20, 6, areas.get(12)));
    }

    @org.junit.jupiter.api.Test
    void testInitItems() {
        assertEquals(3, hollowKnight.howManyItems("LlaveSimple"));
        assertEquals(15, hollowKnight.howManyItems("HuevoPodrido"));
        assertEquals(0, hollowKnight.howManyItems("SelloDeHallownest"));
        assertEquals(1, hollowKnight.howManyItems("MarcaDelRey"));
        assertEquals(1, hollowKnight.howManyItems("BendicionDeSalubra"));
    }

    @org.junit.jupiter.api.Test
    void testExistingItem() {
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> hollowKnight.newItem("LlaveSimple"));

        assertEquals("Ya existe un elemento con ese nombre", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testAddNotExistingItem() {
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> hollowKnight.addItem("ObjetoFalso"));

        assertEquals("No puedes anadir nuevos elementos si no han sido previamente creados", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testAddUseItem() {
        assertEquals(15, hollowKnight.howManyItems("HuevoPodrido"));
        hollowKnight.useItem("HuevoPodrido");
        assertEquals(14, hollowKnight.howManyItems("HuevoPodrido"));
        assertEquals(1, hollowKnight.howManyItems("MarcaDelRey"));
        hollowKnight.useItem("MarcaDelRey");
        assertEquals(0, hollowKnight.howManyItems("MarcaDelRey"));
    }

    @org.junit.jupiter.api.Test
    void testAddUseItemException() {
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> hollowKnight.useItem("SelloDeHallownest"));

        assertEquals("No te quedan SelloDeHallownest, no puedes utilizarlo", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testAddUseItemException2() {
        Exception exception = assertThrows(
                RuntimeException.class,
                () -> hollowKnight.useItem("ObjetoFalso"));

        assertEquals("El elemento que quieres utilizar no existe", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void testMaxEnemies() {
        assertEquals(164, hollowKnight.maxEnemies());
    }

    @org.junit.jupiter.api.Test
    void testCountSteps() {
        int[] expected = new int[]{0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 4, 4, 5, 5};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], hollowKnight.countSteps(areas.get(i)));
        }
    }

}