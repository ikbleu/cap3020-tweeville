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
    int locX;
    int locY;
    UnitStatus status;
    DirectionType direction;
    WeaponType melee;
    WeaponType ranged;
    WeaponType armor;
    AllianceType alliance;
    BattleMap map;
    int hp;
    int movementInc = 2;
    //1130 x 650
    //36 x 80

    Character(String name, int locX, int locY, AllianceType alliance, BattleMap map){
        this.name = name;
        this.locX = locX;
        this.locY = locY;
        this.status = UnitStatus.STANDING;
        this.alliance = alliance;
        this.map = map;
        hp = 100;
    }

    void move(DirectionType direction){
        if(direction == DirectionType.EAST){
            if(map.passable((double)locX+movementInc, (double)locY))
                locX+=movementInc;
        }
        else if(direction == DirectionType.NORTH){
            if(map.passable((double)locX, (double)locY-movementInc))
                locY-=movementInc;
        }
        else if(direction == DirectionType.WEST){
            if(map.passable((double)locX-movementInc, (double)locY))
                locX-=movementInc;
        }
        else if(direction == DirectionType.SOUTH){
            if(map.passable((double)locX, (double)locY+movementInc))
                locY+=movementInc;
        }
        System.out.print(name + " moved to " + locX + ", " + locY);
    }

    public String getCharacter(){
        return name;
    }

    public Point getLocation(){
        return new Point(locX, locY);
    }

    public UnitStatus getStatus(){
        return status;
    }

    public DirectionType getDirection(){
        return direction;
    }
    
}
