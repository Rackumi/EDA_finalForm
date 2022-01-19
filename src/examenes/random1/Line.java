package examenes.random1;

import java.util.LinkedList;
import java.util.List;

public class Line {

    List<String> line = new LinkedList<>();

    public void addStation(String station){
        line.add(station);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("");
        for(String v: line){
            str.append(" ").append(v);
        }
        return str.toString();
    }

}