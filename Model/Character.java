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
    GameMap map;
    int cwidth;
    int cheight;
    int hp;
    int movementInc = 20;
    //1130 x 650
    //36 x 80

    Character(String name, int locX, int locY, int cwidth, int cheight, AllianceType alliance, GameMap map){
        this.name = name;
        this.locX = locX;
        this.locY = locY;
        this.cwidth = cwidth;
        this.cheight = cheight;
        this.status = UnitStatus.STANDING;
        this.alliance = alliance;
        this.map = map;
        hp = 100;
    }

    void move(DirectionType direction){
        if(direction == DirectionType.EAST){
            if(map.passable((double)locX+movementInc, (double)locY, this))
                locX+=movementInc;
        }
        else if(direction == DirectionType.NORTH){
            if(map.passable((double)locX, (double)locY-movementInc, this))
                locY-=movementInc;
        }
        else if(direction == DirectionType.WEST){
            if(map.passable((double)locX-movementInc, (double)locY, this))
                locX-=movementInc;
        }
        else if(direction == DirectionType.SOUTH){
            if(map.passable((double)locX, (double)locY+movementInc, this))
                locY+=movementInc;
        }
        System.out.print(name + " moved to " + locX + ", " + locY);
    }

    void setMelee(WeaponType melee){
        this.melee = melee;
    }

    void setRanged(WeaponType ranged){
        this.ranged = ranged;
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
