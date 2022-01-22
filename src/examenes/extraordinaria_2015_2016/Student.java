package examenes.extraordinaria_2015_2016;

public class Student implements Comparable {

    private String name;
    private String surname;
    private int exp;

    public Student(){

    }

    @Override
    public int compareTo(Object o) {
        Student student1 = this;
        Student student2 = (Student)o;
        int nExp1 = student1.exp;
        int nExp2 = student2.exp;
//        if(nExp1<nExp2){
//            return -1;
//        }
//        else if(nExp1==nExp2){
//            return 0;
//        }
//        else {
//            return 1;
//        }
        return Integer.compare(nExp1, nExp2); //lo mismo ke lo de arriba
    }
}