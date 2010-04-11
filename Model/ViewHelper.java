/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.List;

/**
 *
 * @author spock
 */
public interface ViewHelper {
    public abstract List<Character> getUnits();
    public abstract Character getCurrChar();
    public abstract WeaponType getBScurrentMelee();
    public abstract WeaponType getBScurrentRanged();
    public abstract WeaponType getBScurrentArmor();
    public abstract int[] getHPs();
    public abstract ViewCooldown[][] getCoolDowns();
    public abstract List<String> getDialogue();
    public abstract int getDialogueSelection();
}
