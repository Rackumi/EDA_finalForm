package examenes.extra7.ejercicio2;

/**
 *
 * @author Rackumi
 */
public class MyFile {

    String contents;

    public MyFile(String data) {
        contents = data;
    }

    public String getContents() {
        return contents;
    }

}

//seria mejor usar esto que es codigo que ya viene en el enunciado

//class MyFile {
//    long lastmodified;
//    String contents;
//    public MyFile(long last, String data) {
//        lastmodified=last;
//        contents=data;
//    }
//    public long getLastModified() {return lastmodified;}
//    public String getContents() {return contents;}
//}
//
//public class MRUCache {
//    int cachesize;
//    public MRUCache(int max) {cachesize=max;}
//    public String getFile(String fname){}
//    protected MyFile readFileFromDisk(String fname) {}
//    public void printMRU() {}
//    public static void main(String args[]) {
//        // Number of entries in MRU cache is set to 10
//        MRUCache h1=new MRUCache(10);
//        for(int i=1;i<=20;i++) {
//            // files are stored in a subdirectory called data
//            h1.getFile("data"+File.separatorChar+i);
//        }
//        h1.printMRU();
//    }
//}