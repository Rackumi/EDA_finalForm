package examenes.extra1.source.canals;

/**
 *
 * @author Rackumi
 */
public class House implements CanalizationElement {

    final String adress;
    final int num;

    public House(String adress, int num) {
        this.num = num;
        this.adress = adress;
    }
    
    @Override
    public String getAdress() {
        return adress;
    }
    
}