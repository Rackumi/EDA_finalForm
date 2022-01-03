package examenes.extra2.source.netflix;

import java.util.List;

public class Movie {

    private String titulo;
    private int ano;
    private List<String> tipo;

    public Movie(String titulo, int ano, List<String> tipo) {
        this.titulo = titulo;
        this.ano = ano;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<String> getTipo() {
        return tipo;
    }

    public void setTipo(List<String> tipo) {
        this.tipo = tipo;
    }

}