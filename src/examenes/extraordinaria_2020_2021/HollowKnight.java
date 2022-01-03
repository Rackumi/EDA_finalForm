package examenes.extraordinaria_2020_2021;

import structures.Position;
import structures.tree.narytree.LinkedTree;
import structures.tree.narytree.NAryTree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HollowKnight {

    private class Objeto {

        private String descripcion;
        private int n;

        public Objeto(String descripcion, int n){
            this.descripcion = descripcion;
            this.n = n;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }

    Map<String, Objeto> objetos = new HashMap<>();
    NAryTree<Area> zonaTree = new LinkedTree<>();

    public void newItem(String name) {
        if(objetos.containsKey(name)){
            throw new RuntimeException("Ya existe un elemento con ese nombre");
        }

        Objeto item1 = new Objeto("descrip1", 0);
        objetos.put(name, item1);
    }

    public void addItem(String name) {
        if(!objetos.containsKey(name)){
            throw new RuntimeException("No puedes anadir nuevos elementos si no han sido previamente creados");
        }
        int elem = objetos.get(name).getN();
        objetos.get(name).setN(elem+1);
    }

    public void useItem(String name) {
        if(!objetos.containsKey(name)){
            throw new RuntimeException("El elemento que quieres utilizar no existe");
        }
        int elems = objetos.get(name).getN();
        if(elems == 0){
            throw new RuntimeException("No te quedan "+name+", no puedes utilizarlo");
        }
        objetos.get(name).setN(elems-1);
    }

    public int howManyItems(String name) {
        return objetos.get(name).getN();
    }

    public Position<Area> addArea(String name, int enemies, int difficulty) {
        Area area = new Area(name, difficulty, enemies);
        return zonaTree.addRoot(area);
    }

    public Position<Area> addArea(String name, int enemies, int difficulty, Position<Area> previous) {
        Area area = new Area(name, difficulty, enemies);
        return zonaTree.add(area, previous);
    }

    public int maxEnemies() {
        return maxEnemiesRec(zonaTree.root());
    }

    private int maxEnemiesRec(Position<Area> current) {
        if(zonaTree.isLeaf(current)){
            return current.getElement().getnEnemigos();
        }

        LinkedList<Integer> l = new LinkedList<>();
        for(Position<Area> p: zonaTree.children(current)){
            l.add(current.getElement().getnEnemigos() + maxEnemiesRec(p));
        }
        return Collections.max(l);
    }

    public int countSteps(Position<Area> destination) {
        if(destination == zonaTree.root()){
            return 0;
        }
        Position<Area> aux = zonaTree.parent(destination);
        int cont = 1;
        while (aux != zonaTree.root()){
            cont++;
            aux = zonaTree.parent(aux);
        }
        return cont;
    }

}