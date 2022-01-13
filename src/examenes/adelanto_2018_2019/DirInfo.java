package examenes.adelanto_2018_2019;

import structures.orderedMapsAndDictionaries.ordereddictionary.AVLOrderedDict;
import structures.orderedMapsAndDictionaries.ordereddictionary.Entry;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DirInfo {

    public class Elem implements Comparable{
        private boolean fich; //true si es fichero false si directorio
        private int tamano; //solo fichero
        private boolean oculto;
        private String fechaMod;

        public Elem(boolean fich, int tamano, boolean oculto, String fechaMod) {
            this.fich = fich;
            this.tamano = tamano;
            this.oculto = oculto;
            this.fechaMod = fechaMod;
        }

        public boolean isFich() {
            return fich;
        }

        public void setFich(boolean fich) {
            this.fich = fich;
        }

        public int getTamano() {
            return tamano;
        }

        public void setTamano(int tamano) {
            this.tamano = tamano;
        }

        public boolean isOculto() {
            return oculto;
        }

        public void setOculto(boolean oculto) {
            this.oculto = oculto;
        }

        public String getFechaMod() {
            return fechaMod;
        }

        public void setFechaMod(String fechaMod) {
            this.fechaMod = fechaMod;
        }

        @Override
        public int compareTo(Object o) {
            Elem e = (Elem)o;
            if(this.getTamano() > e.getTamano()) {
                return 1;
            }
            else if(this.getTamano() == e.getTamano()) {
                return 0;
            }
            else{
                return -1;
            }
        }

    }

    private final AVLOrderedDict<Integer, Elem> dic = new AVLOrderedDict();

    public Collection<Elem> gimeMeFiles(){
        List<Elem> l = new LinkedList<>();
        Iterable<Entry<Integer, Elem>> it = dic.findRange(dic.first().getKey(), dic.last().getKey());
        for(Entry<Integer, Elem> p: it){
            if(p.getValue().isFich()){
                l.add(p.getValue());
            }
        }
        return l;
    }

    public int distance(Elem f1, Elem f2){

        Iterable<Entry<Integer, Elem>> it = dic.findRange(dic.find(f1.tamano).getKey(), dic.find(f2.tamano).getKey());
        int cont = 0;
        for(Entry<Integer, Elem> p: it){
            if(!p.getValue().isFich()){
                cont++;
            }
        }
        return cont;
    }

}