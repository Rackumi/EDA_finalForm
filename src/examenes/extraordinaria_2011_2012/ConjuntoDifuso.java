package examenes.extraordinaria_2011_2012;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoDifuso {

    Set<Double> set = new HashSet<>();

    public ConjuntoDifuso(double[] doubles){
        for(double p: doubles){
            set.add(p);
        }

    }

    public double busquedaAproximada(double valorABuscar){
        if(set.isEmpty()){
            throw new RuntimeException("set is empty");
        }
        return 0;
    }

}