package examenes.ordinaria_2012_2013;

import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.HashSet;
import java.util.Set;

public class CentroControl {

	Set<Multa> multas = new HashSet<>();
	Map<String, Float> conductores = new HashTableMapDH<>();
	Map<Integer, Integer> radares = new HashTableMapDH<>();
	Integer radarMasValioso = null;
	int maxRadar = 0;

	public void storeMultas(Multa multa){
		multas.add(multa);
	}

	public void setMulta (Multa m) {
		String matricula = m.getMatricula();
		Float importe = m.getImporteAPagar();
		Integer radar = m.getIdRadar();

		Float importeConductor = conductores.get(matricula);
		if(importeConductor == null){
			conductores.put(matricula, importe);
		}
		else{
			conductores.put(matricula, importe+importeConductor);
		}

		Integer importeRadar = radares.get(radar);
		if(importeRadar == null){
			radares.put(radar, 1);
		}
		else{
			radares.put(radar, 1+importeRadar);
		}

		//con eso nos ahorramos la complejidad O(n) de getRadarMasValioso al tener que iterar el mapa radares
		importeRadar = radares.get(radar); //actualizamos el valor
		if(importeRadar > maxRadar){
			maxRadar = importeRadar;
			radarMasValioso = radar;
		}

	}

	public float getCuantia (String matricula) {
		return conductores.get(matricula);
	}

	public int getRadarMasValioso () {
//		int max = 0;
//		int radarValioso = 0;
//		for(Entry<Integer, Integer> ent: radares.entries()){
//			if(ent.getValue() > max){
//				max = ent.getValue();
//				radarValioso = ent.getKey();
//			}
//		}
		return this.radarMasValioso;
	}

}