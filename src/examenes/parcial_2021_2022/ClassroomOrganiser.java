package examenes.parcial_2021_2022;

import java.util.List;

import practicas.practica2.Pair;
import structures.notOrderedMapsAndDictionaries.maps.HashTableMapDH;
import structures.notOrderedMapsAndDictionaries.maps.Map;

/**
 * @author Rackumi
 */
//El enunciado que tenemos es del examen de vicalvaro y el codigo es el del examen de mostoles, por eso difiere un poco el contenido
public class ClassroomOrganiser {

    Map<Integer, Integer> map; //entendemos la clave es el code de subject y el aula seria el valor ya que se identifica por un numero
    Map<Integer, Subject> subjects;

    /**
     * Initializes the organiser
     */
    public ClassroomOrganiser(){
        map = new HashTableMapDH<>();
        subjects = new HashTableMapDH<>();
    }
    
    /**
     * Initializes the organiser
     * @param lista 
     */
    public ClassroomOrganiser(List<Pair<Subject, Integer>> lista) {
        map = new HashTableMapDH<>();
        subjects = new HashTableMapDH<>();
        for(Pair<Subject, Integer> p : lista){
            map.put(p.getFirst().getCode(), p.getSecond());
            subjects.put(p.getFirst().getCode(), p.getFirst());
        }
    }

    /**
     * Returns the list of classrooms in which the subject is imparted
     * @param
     * @return 
     */
    public List<Integer> impartedSubject(Integer subject) { //enunciado alternativo con varias classrooms
        return null;
    }

    /**
     * Returns the classrooms in which the subject is imparted
     * @param subject Subject identifier
     * @return 
     */
    public Integer classroomAsigned(Integer subject) {
        Integer resp = map.get(subject);
        if(resp != null){
            throw new RuntimeException("No existe una asignatura con ese codigo");
        }
        return resp;
    }

    /**
     * Adds a new subject and a their list of classrooms to the classroom organizer
     * If the subject is already in the classroom organizer, it is a change of classrooms
     * @param classrooms The list of classrooms
     * @return 
     */
    public void newSubject(Subject subject, List<Integer> classrooms) { //enunciado alternativo con varias classrooms
    }

    /**
     * Adds a new subject and its classroom to the classroom organizer
     * @param subject The subject
     * @param classroom The classroom
     * @return 
     */
    public void newSubject(Subject subject, Integer classroom) {
        subjects.put(subject.getCode(), subject);
        Integer aux = map.put(subject.getCode(), classroom);
        if(aux!=null){
            throw new RuntimeException("Error, la classroom ya estaba siendo utilizada");
        }
    }

    /**
     * Adds a new classroom to the subject's classrooms
     * @param classroom The classroom
     * @return 
     */
    public void addClassroom(Subject subject, Integer classroom) { //enunciado alternativo con varias classrooms
    }

    /**
     * Change the classroom in which the subject is imparted
     * @param subject The subject
     * @param classroom The classroom
     * @return 
     */
    public void changeClassroom(Subject subject, Integer classroom) {
        Integer aux = map.get(subject.getCode());
        if(aux==null){
            throw new RuntimeException("error, la asignatura no existe");
        }
        map.put(subject.getCode(), classroom);
    }

    /**
     * Change the topic at index of the syllabus subject
     * @param subject The subject's code
     * @param topic
     * @param index
     * @return 
     */
    public void changeSyllabus(Integer subject, String topic, Integer index) {
        Subject s = subjects.get(subject);
        String[] str = s.getSyllabus();
        str[index] = topic;
    }

    /**
     * Prints the subject assigned to the given classroom
     * @param classroom
     * @return 
     */
    public void printSubject(Integer classroom) {
        System.out.println(map.get(classroom));
    }
    
    /**
     * Return true if the classroom is free, false otherwise
     * @param classroom
     * @return 
     */
    public boolean freeClassroom(Integer classroom) {
        return map.get(classroom) == null;
    }
    
}