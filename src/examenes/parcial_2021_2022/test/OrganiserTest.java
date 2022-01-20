package examenes.parcial_2021_2022.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import practicas.practica2.Pair;

import static org.junit.Assert.*;

/**
 * @author Rackumi
 */
public class OrganiserTest { //son tests para otro enunciado parecido
    
    public OrganiserTest() {
    }

//    private Student s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13;
//    private String a1 = "Algebra", a2 = "Calculo", a3 = "Introduccion a la Programacion", a4 = "Estructuras de Datos";
//    private String a5 = "Programación Orientada a Objetos", a6 = "Teoria de automatas y lenguajes formales", a7 = "Programacion declarativa";
//    private String a8 = "Diseño y analisis de algoritmos";
//    private List<Pair<String,List<Student>>> inicializa(){
//        s1 = new Student("Ana","Garcia", new DNI(03456712,'B'));
//        s2 = new Student("Alfredo","Lopez", new DNI(47127391,'V'));
//        s3 = new Student("Fabian","Valor", new DNI(243718,'K'));
//        s4 = new Student("Maria","Asensio", new DNI(01526340,'S'));
//        s5 = new Student("Javier","Borjas", new DNI(37129166,'P'));
//        s6 = new Student("Jose","Ruiz", new DNI(07743122,'F'));
//        s7 = new Student("Berta","Diaz", new DNI(11748921,'J'));
//        s8 = new Student("Hugo","Fernandez", new DNI(27654128,'Y'));
//        s9 = new Student("Tais","Rebollo", new DNI(5618215,'D'));
//        s10 = new Student("Alexis","Wolf", new DNI(56123412,'S'));
//        s11 = new Student("Pedro","Ortiz", new DNI(19876567,'U'));
//        s12 = new Student("Luis","Junco", new DNI(22678126,'K'));
//        s13 = new Student("Gloria","Garcia", new DNI(03456713,'N'));
//        List<Pair<String,List<Student>>> l = new ArrayList<>();
//        l.add(new Pair(a1,Arrays.asList(s1,s2,s3)));
//        l.add(new Pair(a2,Arrays.asList(s4,s5,s6)));
//        l.add(new Pair(a3,Arrays.asList(s7,s8,s9)));
//        l.add(new Pair(a4,Arrays.asList(s10,s11,s12,s13)));
//        l.add(new Pair(a5,Arrays.asList(s1,s3,s5)));
//        l.add(new Pair(a6,Arrays.asList(s7,s9,s11,s13)));
//        l.add(new Pair(a7,Arrays.asList(s2,s4,s6)));
//        l.add(new Pair(a8,Arrays.asList(s8,s10,s12)));
//
//        return l;
//    }
//    @Test
//    public void testEnrolledSubjects() {
//        System.out.println("enrolledSubjects");
//        List<Pair<String,List<Student>>> lista = inicializa();
//        Organiser instance = new Organiser(lista);
//        DNI identificador = new DNI(423,'R');
//        List<String> subjects = instance.enrolledSubjects(identificador);
//        assertEquals(subjects,null);
//        Set<String> s = new HashSet<>(Arrays.asList(a4,a8));
//        identificador = new DNI(22678126,'K');
//        subjects = instance.enrolledSubjects(identificador);
//        assertTrue(s.containsAll(subjects));
//        assertEquals(s.size(),subjects.size());
//
//    }
//
//    @Test
//    public void testNewStudent(){
//        System.out.println("newStudent");
//       // List<Pair<String,List<Student>>> lista = inicializa();
//        Organiser instance = new Organiser();
//        DNI identificador = new DNI(16765423,'R');
//        List<String> subjects = instance.enrolledSubjects(identificador);
//        assertEquals(subjects,null);
//        List<String> l = Arrays.asList(a8,a7,a6);
//        Student s = new Student("Francisco", "Cullera", identificador);
//        instance.newStudent(s,l);
//        subjects = instance.enrolledSubjects(identificador);
//        Set<String> materias = new HashSet<>(Arrays.asList(a8,a7,a6));
//        assertTrue(materias.containsAll(subjects));
//        assertEquals(materias.size(),subjects.size());
//    }
//
//    @Test
//    public void testStudentData(){
//        System.out.println("studentData");
//        List<Pair<String,List<Student>>> lista = inicializa();
//        Organiser instance = new Organiser(lista);
//        DNI identificador = new DNI(16765423,'R');
//        String uno = instance.studentData(identificador);
//        assertEquals(uno,null);
//        String dos = instance.studentData(new DNI(11748921,'J'));
//        assertEquals(dos,"Student: name=Berta, lastname=Diaz, dni=11748921-J");
//    }
//
//    /**
//     * Test of registrationChange method, of class Organiser.
//     */
//    @Test
//    public void testRegistrationChange() {
//        System.out.println("registrationChange");
//        List<Pair<String,List<Student>>> lista = inicializa();
//        Organiser instance = new Organiser(lista);
//        List<String> l = Arrays.asList(a8,a7,a6);
//        DNI identificador = new DNI(16765423,'R');
//        Student s = new Student("Francisco", "Cullera", identificador);
//        try{
//            instance.registrationChange(s, l);
//        }catch(RuntimeException e){
//            System.out.println(e.getMessage());
//        }
//        List<String> enrolledSubjects = instance.enrolledSubjects(new DNI(243718,'K'));
//        Set<String> materias = new HashSet<>(Arrays.asList(a1,a5));
//        assertTrue(materias.containsAll(enrolledSubjects));
//        assertEquals(materias.size(),enrolledSubjects.size());
//
//        instance.registrationChange(s3,l);
//        materias = new HashSet<>(l);
//        enrolledSubjects = instance.enrolledSubjects(new DNI(243718,'K'));
//        assertTrue(materias.containsAll(enrolledSubjects));
//        assertEquals(materias.size(),enrolledSubjects.size());
//    }
}
