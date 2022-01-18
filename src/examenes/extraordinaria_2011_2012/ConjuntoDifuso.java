package examenes.extraordinaria_2011_2012;

import structures.orderedMapsAndDictionaries.ordereddictionary.AVLOrderedDict;
import structures.orderedMapsAndDictionaries.ordereddictionary.Entry;
import structures.orderedMapsAndDictionaries.ordereddictionary.OrderedDictionary;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConjuntoDifuso {

    private final AVLOrderedDict<Double, Double> treeMap = new AVLOrderedDict<>();

    public ConjuntoDifuso(double[] doubles){
        for(double p: doubles){
            treeMap.insert(p, p);
        }
    }

    public double busquedaAproximada(double valorABuscar){
        if(treeMap.isEmpty()){
            throw new RuntimeException("set is empty");
        }
        Entry<Double, Double> value = treeMap.find(valorABuscar);
        if(value != null){
            return value.getValue();
        }
        else{
            double first = treeMap.first().getKey();
            double last = treeMap.last().getKey();
            if(valorABuscar < first){
                return first;
            }
            if(valorABuscar > last){
                return last;
            }

            List<Entry<Double, Double>> l = (List<Entry<Double, Double>>) treeMap.findRange(first, valorABuscar);
            Entry<Double, Double> ant = l.remove(l.size()-1);
            Entry<Double, Double> desp = treeMap.findRange(valorABuscar, last).iterator().next();

            double dif1 = Math.abs(ant.getValue()-valorABuscar);
            double dif2 = Math.abs(desp.getValue()-valorABuscar);
            if(dif1<dif2){
                return ant.getValue();
            }
            else{
                return desp.getValue();
            }
        }
    }

    public static void main(String[] args){
        double[] arrayD = {1, 3, 53, 2, 10, 200, 1000};
        ConjuntoDifuso conjuntoDifuso = new ConjuntoDifuso(arrayD);
        System.out.println(conjuntoDifuso.busquedaAproximada(0));
    }

}