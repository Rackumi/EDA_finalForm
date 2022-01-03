package examenes.ordinaria_2019_2020.solucion;

import java.util.Objects;

public class Visit {

    private String name;
    private int money;

    public Visit(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    //Es necesario implementar hashcode y equals para mapas con esta clase
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit famous = (Visit) o;
        return Objects.equals(name, famous.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}