/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author spock
 */
public interface ViewHelper {
    public abstract Viewable[] getUnits();
    public abstract WeaponType getBScurrentMelee();
    public abstract WeaponType getBScurrentRanged();
    public abstract WeaponType getBScurrentArmor();
    public abstract int[] getHPs();
    public abstract ViewCooldown[][] getCoolDowns();
}
