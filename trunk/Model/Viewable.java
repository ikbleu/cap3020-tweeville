/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Point;

/**
 *
 * @author spock
 */
public interface Viewable {
    public abstract UnitStatus getStatus();
    public abstract Point getLocation();
    public abstract String getCharacter();
}
