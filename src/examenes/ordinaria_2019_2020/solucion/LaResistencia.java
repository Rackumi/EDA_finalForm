package examenes.ordinaria_2019_2020.solucion;

import structures.Position;
import structures.tree.binarySearchTree.BinarySearchTree;

import java.util.*;

public class LaResistencia {
    //1 - Se necesita una estructura ordenada para obtener eficientemente
    //la mediana y los que esten por encima de ella. Si no mantenemos el
    //orden habria que ordenar en cada llamada a overMedian() y seria
    //O(nlogn)
    // Para actualizar el arbol sin buscar cada vez necesitamos un mapa
    // que relacione cada famoso con su position en el arbol.

    private BinarySearchTree<Visit> people;
    private Map<String, Position<Visit>> positions;

    //2 - Utilizamos mapas a modo de cache para tener precalculado
    //el total acumulado de un mes y la lista de visitas. Asi conseguimos
    //que sea O(1)
    private Map<String, Set<Visit>> visitsInMonth;
    private Map<String, Integer> totalInMonth;

    public LaResistencia() {
//        people = new AVLTree<>(Comparator.comparingInt(Visit::getMoney));
//        //Se puede crear el comparador de varias formas, entre otras:
//        people = new AVLTree<>(Comparator.comparingInt(visit -> visit.getMoney())); //funcion lambda
//        people = new AVLTree<Visit>(new Comparator<Visit>() { //clase anonima
//            @Override
//            public int compare(Visit o1, Visit o2) {
//                return Integer.compare(o1.getMoney(), o2.getMoney());
//            }
//        });
//
//        visitsInMonth = new HashMap<>();
//        totalInMonth = new HashMap<>();
//        positions = new HashMap<>();
    }

    //Complejidad: O(logn) (actualizacion del arbol)
    public void addVisit(String name, int money, String month) {
        Visit famous = new Visit(name, money);

        //actualizar el arbol: quitar valor antiguo
        if (positions.containsKey(name)) {
            people.remove(positions.get(name));
        }
        Position<Visit> posFamous = people.insert(famous);
        positions.put(name, posFamous);

        //nuevo mes: inicializar los mapas
        if (!visitsInMonth.containsKey(month)) {
            visitsInMonth.put(month, new HashSet<>());
            totalInMonth.put(month, 0);
        }

        //guardar visita
        visitsInMonth.get(month).add(famous);
        //actualizar total del mes
        int total = totalInMonth.get(month);
        totalInMonth.put(month, total + money);
    }

    //Complejidad O(n)
    public Iterable<String> overMedian() {

        //encontrar posicion de la mediana
        int posMedian = people.size() / 2;
        Iterator<Position<Visit>> it = people.iterator();
        Position<Visit> pMedian = null;
        for (int i = 0; i < posMedian; i++) {
            pMedian = it.next();
        }
        int median = pMedian.getElement().getMoney();

        //comprobar/guardar elementos restantes
        List<String> output = new ArrayList<>();
        while (it.hasNext()) {
            Position<Visit> pNext = it.next();
            if (pNext.getElement().getMoney() > median) //comparacion estricta
                output.add(pNext.getElement().getName());
        }
        return output;
    }

    //Complejidad: O(1)
    public int moneyInMonth(String month) {
        return totalInMonth.getOrDefault(month, 0);
    }

    //Complejidad: O(1)
    public Iterable<Visit> visitsInMonth(String month) {
        return visitsInMonth.getOrDefault(month, Collections.emptySet());
    }

    //No se considera correcto ordenar en overMedian(), la compejidad seria O(nlogn)

    //No se considera correcto que moneyInMonth o visitsInMonth sea O(n) y/o que haya
    //que recorrer una estructura de datos para devolver el resultado.

    //Ademas, NUNCA se recorre un mapa con un for (salvo situaciones excepcionales)
    //la razon fundamental para usar un mapa es tener acceso O(1) a sus elementos
    //mediante la clave.

}