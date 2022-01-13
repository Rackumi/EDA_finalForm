package practicas.practica4;

/**
 * @author Rackumi
 */
public class ParchisBoard {
    
    public enum Color {red,green,blue,yellow};
    public enum SquareType {Normal, Home, Destiny};

    /**
     * Crea un tablero de parchis con todas sus casillas y con 4 piezas de cada
     * color en sus casas correspondientes.
     */
    public ParchisBoard() {
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param c la ficha a mover
     * @param n el número de casillas a mover.
     * @return Devuelve true si el movimiento es posible y false en caso contraio.
     */
    public boolean canMove(ParchisChip c, int n) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @return Devuelve una cadena con las casillas ocupadas del tablero y su contenido.
     */
    public String drawBoard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}