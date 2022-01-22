package examenes.extraordinaria_2015_2016;

import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

public class ElectoralCollege {

    private class Votante{

        private String dni;
        private String calle;
        private String mesa;

        public Votante(String dni, String colegio, String mesa) {
            this.dni = dni;
            this.calle = colegio;
            this.mesa = mesa;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getColegio() {
            return calle;
        }

        public void setColegio(String colegio) {
            this.calle = colegio;
        }

        public String getMesa() {
            return mesa;
        }

        public void setMesa(String mesa) {
            this.mesa = mesa;
        }
    }

    private Map<String, Votante> votantes = new HashTableMapDH<>();

    public void addVoter(String[] info){
        Votante votante = new Votante(info[0], info[1], info[2]);
        votantes.put(info[0], votante);
    }

    public void makeStationDistribution(){

    }

    public void getAllVoters(){

    }

    public void getStationVoters(String mesa){

    }

}