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
public class Character implements Viewable{
    String name;
    Point location;
    UnitStatus status;
    DirectionType direction;
    WeaponType melee;
    WeaponType ranged;
    WeaponType armor;
    AllianceType alliance;
    //1130 x 650

    Character(String name, int locX, int locY, AllianceType alliance){
        this.name = name;
        this.location = new Point(locX, locY);
        this.status = UnitStatus.STANDING;
        this.alliance = alliance;
    }

    public String getCharacter(){
        return name;
    }

    public Point getLocation(){
        return location;
    }

    public UnitStatus getStatus(){
        return status;
    }

    public DirectionType getDirection(){
        return direction;
    }
    
}
