package examenes.extraordinaria_2012_2013;

import structures.notOrderedMapsAndDictionaries.Entry;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

import java.util.Objects;
import java.util.Scanner;

public class Autentificacion {

    static Map<String, String> bd;

    public Autentificacion(){

    }

    public static void impresion(Map<String, String> bd){
        for(Entry<String, String> entry: bd.entries()){
            System.out.println(entry);
        }
    }

    public static boolean login(String k, String v){
        return bd.get(k) != null && Objects.equals(bd.get(k), v);
    }

    public static void main(String[] srgs){

        bd = new HashTableMapDH<>();
        bd.put("A","1");
        bd.put("B","2");
        bd.put("C","3");
        bd.put("D","4");
        bd.put("E","5");
        bd.put("F","6");
        bd.put("G","7");
        bd.put("H","8");
        bd.put("I","9");
        bd.put("J","10");
        bd.put("K","11");
        impresion(bd);

        Scanner sc = new Scanner(System.in);

        int cont = 0;
        boolean cond = true;
        boolean cond2 = false;

        while(cont < 3 && cond) {
            System.out.print("Introduzca el nombre de usuario: ");
            String nom = sc.nextLine();
            System.out.print("Introduzca la contraseña: ");
            String contr = sc.nextLine();
            System.out.println();

            if(login(nom, contr)){
                System.out.println("Entraste al sistema");
                cond = false;
            }
            else{
                System.out.println("El nombre de usuario y la contraseña no concuerdan");
                cond2 = true;
            }

            cont++;
        }

        if(cond2){
            System.out.println("No entraste al sistema");
        }

    }

}