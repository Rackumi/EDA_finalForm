package practicas.practica4;

import structures.graphs.Vertex;
import structures.graphs.digraph.Digraph;
import structures.graphs.digraph.ELDigraph;

import java.util.*;

/**
 * @author Rackumi
 */
public class ParchisBoard {
    
    public enum Color {red,green,blue,yellow};
    public enum SquareType {Normal, Home, Destiny};

    public static class Square {
        private int casilla;
        private Color color;
        private SquareType squareType;
        private Set<ParchisChip> chips;
        private boolean safe;

        public Square(int casilla, Color color, SquareType squareType, Set<ParchisChip> chips, Boolean safe) {
            this.casilla = casilla;
            this.color = color;
            this.squareType = squareType;
            this.chips = chips;
            this.safe = safe;
        }

        public int getCasilla() {
            return casilla;
        }

        public void setCasilla(int casilla) {
            this.casilla = casilla;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public SquareType getSquareType() {
            return squareType;
        }

        public void setSquareType(SquareType squareType) {
            this.squareType = squareType;
        }

        public Set<ParchisChip> getChips() {
            return chips;
        }

        public void setChips(Set<ParchisChip> chips) {
            this.chips = chips;
        }

        public boolean isSafe() {
            return safe;
        }

        public void setSafe(boolean safe) {
            this.safe = safe;
        }
    }

    public static class ParchisChip {
        private Color color;
        private Vertex<Square> position;

        public ParchisChip(Color color, Vertex<Square> position) {
            this.color = color;
            this.position = position;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Vertex<Square> getPosition() {
            return position;
        }

        public void setPosition(Vertex<Square> position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "ParchisChip{" +
                    "color=" + color +
                    ", position=" + position.getElement().getCasilla() +
                    '}';
        }
    }

    private final Digraph<Square, Integer> g;
    private final Map<Integer, Vertex<Square>> mapNormal;
    private final Map<Integer, Vertex<Square>> mapYellowDestiny;
    private final Map<Integer, Vertex<Square>> mapBlueDestiny;
    private final Map<Integer, Vertex<Square>> mapRedDestiny;
    private final Map<Integer, Vertex<Square>> mapGreenDestiny;
    private final Map<Integer, Vertex<Square>> mapHome;

    /**
     * Crea un tablero de parchis con todas sus casillas y con 4 piezas de cada
     * color en sus casas correspondientes.
     */
    public ParchisBoard() {

        g = new ELDigraph<>();
        mapNormal = new HashMap<>();
        mapYellowDestiny = new HashMap<>();
        mapBlueDestiny = new HashMap<>();
        mapRedDestiny = new HashMap<>();
        mapGreenDestiny = new HashMap<>();
        mapHome = new HashMap<>();

        for(int i = 0; i<=68; i++){
            if(i == 0){ //home
                Square squareY = new Square(i, Color.yellow, SquareType.Home, new HashSet<>(), true);
                Vertex<Square> vSquareY = g.insertVertex(squareY);
//                mapDestiny.put(squareY, vSquareY);
                Set<ParchisChip> yellowSet = new HashSet<>();
                yellowSet.add(new ParchisChip(Color.yellow, vSquareY));
                yellowSet.add(new ParchisChip(Color.yellow, vSquareY));
                yellowSet.add(new ParchisChip(Color.yellow, vSquareY));
                yellowSet.add(new ParchisChip(Color.yellow, vSquareY));
                squareY.setChips(yellowSet);

                Square squareB = new Square(i, Color.blue, SquareType.Home, new HashSet<>(), true);
                Vertex<Square> vSquareB = g.insertVertex(squareB);
//                mapDestiny.put(squareB, vSquareB);
                Set<ParchisChip> blueSet = new HashSet<>();
                blueSet.add(new ParchisChip(Color.blue, vSquareB));
                blueSet.add(new ParchisChip(Color.blue, vSquareB));
                blueSet.add(new ParchisChip(Color.blue, vSquareB));
                blueSet.add(new ParchisChip(Color.blue, vSquareB));
                squareB.setChips(blueSet);

                Square squareR = new Square(i, Color.red, SquareType.Home, new HashSet<>(), true);
                Vertex<Square> vSquareR = g.insertVertex(squareR);
//                mapDestiny.put(squareR, vSquareR);
                Set<ParchisChip> redSet = new HashSet<>();
                redSet.add(new ParchisChip(Color.red, vSquareR));
                redSet.add(new ParchisChip(Color.red, vSquareR));
                redSet.add(new ParchisChip(Color.red, vSquareR));
                redSet.add(new ParchisChip(Color.red, vSquareR));
                squareR.setChips(redSet);

                Square squareG = new Square(i, Color.green, SquareType.Home, new HashSet<>(), true);
                Vertex<Square> vSquareG = g.insertVertex(squareG);
//                mapDestiny.put(squareG, vSquareG);
                Set<ParchisChip> greenSet = new HashSet<>();
                greenSet.add(new ParchisChip(Color.green, vSquareG));
                greenSet.add(new ParchisChip(Color.green, vSquareG));
                greenSet.add(new ParchisChip(Color.green, vSquareG));
                greenSet.add(new ParchisChip(Color.green, vSquareG));
                squareG.setChips(greenSet);

                mapHome.put(0, vSquareY);
                mapHome.put(1, vSquareB);
                mapHome.put(2, vSquareR);
                mapHome.put(3, vSquareG);
            }
            if(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 ||i == 7 || i == 8 || i == 9){ //destiny
                Square squareY = new Square(i, Color.yellow, SquareType.Destiny, new HashSet<>(), true);
                Vertex<Square> vSquareY = g.insertVertex(squareY);

                Square squareB = new Square(i, Color.blue, SquareType.Destiny, new HashSet<>(), true);
                Vertex<Square> vSquareB = g.insertVertex(squareB);

                Square squareR = new Square(i, Color.red, SquareType.Destiny, new HashSet<>(), true);
                Vertex<Square> vSquareR = g.insertVertex(squareR);

                Square squareG = new Square(i, Color.green, SquareType.Destiny, new HashSet<>(), true);
                Vertex<Square> vSquareG = g.insertVertex(squareG);

                mapYellowDestiny.put(i, vSquareY);
                mapBlueDestiny.put(i, vSquareB);
                mapRedDestiny.put(i, vSquareR);
                mapGreenDestiny.put(i, vSquareG);

                if(i != 1){//aristas destino
                    g.insertEdge(mapYellowDestiny.get(i-1), mapYellowDestiny.get(i), 0);
                    g.insertEdge(mapBlueDestiny.get(i-1), mapBlueDestiny.get(i), 0);
                    g.insertEdge(mapRedDestiny.get(i-1), mapRedDestiny.get(i), 0);
                    g.insertEdge(mapGreenDestiny.get(i-1), mapGreenDestiny.get(i), 0);
                }
            }
            if(i != 0) { //normal
                Square square = new Square(i, null, SquareType.Normal, new HashSet<>(), false);
                Vertex<Square> vSquare = g.insertVertex(square);
                mapNormal.put(i, vSquare);
                if (i != 1) {
                    g.insertEdge(mapNormal.get(i-1), vSquare, 0);
                }
                if(i == 5 || i == 12 || i == 17 || i == 22 || i == 29 || i == 34 || i == 39 || i == 46 || i == 51 || i == 56 || i == 63 || i == 68){
                    square.setSafe(true);
                }

            }

        }
        g.insertEdge(mapNormal.get(1), mapNormal.get(68), 0);

        g.insertEdge(mapNormal.get(68), mapYellowDestiny.get(1), 0);
        g.insertEdge(mapNormal.get(17), mapBlueDestiny.get(1), 0);
        g.insertEdge(mapNormal.get(34), mapRedDestiny.get(1), 0);
        g.insertEdge(mapNormal.get(51), mapGreenDestiny.get(1), 0);

        g.insertEdge(mapHome.get(0), mapNormal.get(5), 0);
        g.insertEdge(mapHome.get(1), mapNormal.get(22), 0);
        g.insertEdge(mapHome.get(2), mapNormal.get(39), 0);
        g.insertEdge(mapHome.get(3), mapNormal.get(56), 0);
    }
            
    /**
     * Devuelve una referencia a una ficha contenida en la casilla indicada 
     * por squeareName y cuyo color se corresponde con el color indicado.
     * @param squareNumber número de 0 a 68. 
     *                     - El número de las casillas normales varia de 1 a 68.
     *                     - El número de las casillas destino varia de 1 a 9.
     *                     - El número de las casillas home simpre es 0.
     * @param type tipo de la casilla.
     * @param color de la ficha a devolver.
     * @return Si en la casilla no está la ficha devuelve null, en otro caso 
     * devuelve la ficha obtenida.
     */
    public ParchisChip getChip(int squareNumber, SquareType type, Color color) {
        Vertex<Square> v;
        Set<ParchisChip> s = null;
        if(type == SquareType.Home){
            if(color == Color.yellow){
                v = mapHome.get(0);
                s = v.getElement().getChips();
            }
            if(color == Color.blue){
                v = mapHome.get(1);
                s = v.getElement().getChips();
            }
            if(color == Color.red){
                v = mapHome.get(2);
                s = v.getElement().getChips();
            }
            if(color == Color.green){
                v = mapHome.get(3);
                s = v.getElement().getChips();
            }
            for (ParchisChip parchisChip : s) {
                return parchisChip;
            }
        }
        if(type == SquareType.Destiny){
            if(color == Color.yellow){
                v = mapYellowDestiny.get(squareNumber);
                s = v.getElement().getChips();
            }
            if(color == Color.blue){
                v = mapBlueDestiny.get(squareNumber);
                s = v.getElement().getChips();
            }
            if(color == Color.red){
                v = mapRedDestiny.get(squareNumber);
                s = v.getElement().getChips();
            }
            if(color == Color.green){
                v = mapGreenDestiny.get(squareNumber);
                s = v.getElement().getChips();
            }
            for (ParchisChip parchisChip : s) {
                return parchisChip;
            }
        }
        if(type == SquareType.Normal){
            v = mapNormal.get(squareNumber);
            s = v.getElement().getChips();
            for (ParchisChip parchisChip : s) {
                if(color == parchisChip.getColor()){
                    return parchisChip;
                }
            }
        }
        return null;
    }
    
    /**
     * Mueve la ficha c el número de posiciones indicado por n. Si la ficha 
     * llega a la casilla de entrada a casa debe tomar el camino correspondiente.
     * @param c el color
     * @return Si la ficha cae en una casilla en la que hay una ficha 
     * de otro color (y no es segura) devuelve la otra ficha (que se ha comido)
     * y que automáticamente se habrá ido a la casa de su color.
     * En otro caso devuelve null.
     * Si el movimiento no fue posible (por haber un puente en el destino ) 
     * lanzará una excepción.
     */
    public ParchisChip move(ParchisChip c, int n) {
        if(!mapNormal.get(n).getElement().getChips().isEmpty()){
            for(ParchisChip pc: mapNormal.get(n).getElement().getChips()) {
                pc.setPosition(mapBlueDestiny.get(0));
                return pc;
            }
        }
        if(canMove(c,n)){
            c.setPosition(mapNormal.get(n));
        }
        else{
            throw new RuntimeException("cant move");
        }

        return null;
    }

    /**
     * 
     * @param c la ficha a mover
     * @param n el número de casillas a mover.
     * @return Devuelve true si el movimiento es posible y false en caso contraio.
     */
    public boolean canMove(ParchisChip c, int n) {
        return true;
    }

    /**
     * 
     * @return Devuelve una cadena con las casillas ocupadas del tablero y su contenido.
     */
    public String drawBoard() {
        StringBuilder str = new StringBuilder();
        for(Integer i: mapHome.keySet()){
            Set<ParchisChip> s = mapHome.get(i).getElement().getChips();
            if(i == 0){
                str.append("Yellow Home->Yellow(").append(s.size()).append(")\n");
            }
            if(i == 1){
                str.append("Blue Home->Blue(").append(s.size()).append(")\n");
            }
            if(i == 2){
                str.append("Red Home->Red(").append(s.size()).append(")\n");
            }
            if(i == 3){
                str.append("Green Home->Green(").append(s.size()).append(")\n");
            }
        }
        for(Integer i: mapYellowDestiny.keySet()){
            Set<ParchisChip> s = mapYellowDestiny.get(i).getElement().getChips();
            for(ParchisChip pc: s){
                str.append(pc);
            }
        }
        for(Integer i: mapBlueDestiny.keySet()){
            Set<ParchisChip> s = mapBlueDestiny.get(i).getElement().getChips();
            for(ParchisChip pc: s){
                str.append(pc);
            }
        }
        for(Integer i: mapRedDestiny.keySet()){
            Set<ParchisChip> s = mapRedDestiny.get(i).getElement().getChips();
            for(ParchisChip pc: s){
                str.append(pc);
            }
        }
        for(Integer i: mapGreenDestiny.keySet()){
            Set<ParchisChip> s = mapGreenDestiny.get(i).getElement().getChips();
            for(ParchisChip pc: s){
                str.append(pc);
            }
        }
        for(Integer i: mapNormal.keySet()){
            Set<ParchisChip> s = mapNormal.get(i).getElement().getChips();
            if(i == 5){
                System.out.println(mapNormal.get(i).getElement().chips);
            }
            for(ParchisChip pc : s){
//                str.append(i+"->"++"("+"").append(s.size()).append(")\n");

            }
        }
        System.out.println(str);
        return str.toString();
    }

}