/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;


import java.util.HashMap;
import Model.UnitStatus;

/**
 *
 * @author spock
 */
class StatusAnimator {

    HashMap< UnitStatus, String > staTrans;

    private StatusAnimator(){
        staTrans = new HashMap<UnitStatus, String>();
        try{
	    staTrans.put( UnitStatus.SSOUTH, "01");
            staTrans.put( UnitStatus.WSOUTH1, "02");
            staTrans.put( UnitStatus.WSOUTH2, "03");
            staTrans.put( UnitStatus.SNORTH, "04");
            staTrans.put( UnitStatus.WNORTH1, "05");
            staTrans.put( UnitStatus.WNORTH2, "06");
            staTrans.put( UnitStatus.SWEST, "07");
            staTrans.put( UnitStatus.WWEST, "08");
            staTrans.put( UnitStatus.SEAST, "09");
            staTrans.put( UnitStatus.WEAST, "10");
            staTrans.put( UnitStatus.AEAST, "11");
            staTrans.put( UnitStatus.AWEST, "12");
            staTrans.put( UnitStatus.ANORTH, "13");
            staTrans.put( UnitStatus.ASOUTH, "14");
            
        }
        catch(Exception e){
            System.out.println("Image loading failed");
        }
    }

    String getStatus(UnitStatus key){
        return staTrans.get(key);
    }
    private static class StatusAnimatorHolder {
        private static final StatusAnimator ONEANDONLY =
                                            new StatusAnimator();
    }

    public static StatusAnimator getInstance() {
        return StatusAnimatorHolder.ONEANDONLY;
    }
}