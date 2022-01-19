package examenes.ordinaria_2013_2014.ej3;

public class Viaje {

    private String origen;
    private String destino;
    private int duracion;

    public Viaje(String o, String d, int dur){
        this.origen = o;
        this.destino = d;
        this.duracion = dur;
    }

    public String getOrigen(){
        return this.origen;
    }

    public String getDestino(){
        return this.destino;
    }

    public int getDuracion(){
        return this.duracion;
    }

}