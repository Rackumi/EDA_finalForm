package examenes.ordinaria_2012_2013.solucion;

import java.util.ArrayList;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapLP;

public class CentroControl {

    HashTableMapLP<String, ArrayList<Multa>> mapa_por_matricula =
            new HashTableMapLP<>();
    
    HashTableMapLP<Integer, ArrayList<Multa>> mapa_por_radar =
            new HashTableMapLP<>(); 
    
    Integer idMaxValioso = null;
    public void setMulta(Multa m) {
        ArrayList<Multa> multas = mapa_por_matricula.get (m.getMatricula());
        if (multas==null) {
            multas = new ArrayList<> ();
            multas.add (m);
            mapa_por_matricula.put (m.getMatricula(), multas);
        }else {
            multas.add (m);
        }
        
        multas = mapa_por_radar.get (m.getIdRadar());
        if (multas==null) {
            multas = new ArrayList<> ();
            multas.add (m);
            mapa_por_radar.put (m.getIdRadar(), multas);
        }else {
            multas.add (m);
        }
        if (idMaxValioso==null) {
            idMaxValioso=m.getIdRadar();
        }else {
            if (multas.size()> mapa_por_radar.get (idMaxValioso).size()) {
                idMaxValioso=m.getIdRadar();
            }
        }
    }

    public float getCuantia(String matricula) {
        float acu = 0;
        ArrayList<Multa> multas = mapa_por_matricula.get (matricula);
        
        if (multas!=null) {
            for (Multa m: multas) {
                acu = acu + m.getImporteAPagar();
            }
        }
        return acu;
    }

    public int getRadarMasValioso() {
        return idMaxValioso;

    }

}