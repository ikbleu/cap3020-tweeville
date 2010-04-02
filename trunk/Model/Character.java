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

    Character(String name, Point location, UnitStatus status){
        this.name = name;
        this.location = location;
        this.status = status;
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
    
}
