package examenes.extra1.source.lan;

/**
 *
 * @author Rackumi
 */
public class Router implements Host {
    
    final String IPInt;
    final String IPExt;
    final String MACInt;
    final String MACExt;
    
    public Router(final String internalMacAddress, final String externalMacAddress, final String internalIPAddress, final String externalIPAddress) {
        MACInt = internalMacAddress;
        MACExt = externalMacAddress;
        IPExt = externalIPAddress;
        IPInt = internalIPAddress;
    }

    @Override
    public String getIP() {
        return IPInt;
    }

}