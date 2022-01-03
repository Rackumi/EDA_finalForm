package examenes.extra1.source.canals;

/**
 *
 * @author Rackumi
 */
public class Central implements CanalizationElement {
    
    final String adress;
    
    public Central(final String adress) {
        this.adress = adress;
    }

    @Override
    public String getAdress() {
        return adress;
    }

}