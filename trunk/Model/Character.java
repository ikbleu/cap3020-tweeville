/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author spock
 */
public class Character implements Viewable, Comparable{
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
    double centerX;
    double centerY;
    double bubble;
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
        this.centerX = locX + cwidth/2;
        this.centerY = locY + cheight * 7 / 8;
        this.bubble = Math.sqrt( (this.centerX - (locX + this.cwidth)) * (this.centerX - (locX + this.cwidth))
                                + (this.centerY - (locY + this.cheight)) * (this.centerY - (locY + this.cheight)) );

        hp = 100;
    }

    boolean move(DirectionType direction, ArrayList<Character> units, ArrayList<Character> accept, Character curr){
        boolean move = true;
        if(direction == DirectionType.EAST){
            if(map.passable((double)locX+movementInc, (double)locY, this)){
                for(int i = 0; i < units.size(); ++i){
                    if(!(units.get(i).distance((double)centerX+movementInc, (double)centerY))){
                       if(units.get(i)!=this && !(accept.contains(units.get(i)) && this==curr))
                        move = false;
                    }
                }
                if(move){
                    locX+=movementInc;
                    this.centerX = locX + cwidth/2;
                    this.centerY = locY + cheight * 7 / 8;
                }
            }
        }
        else if(direction == DirectionType.NORTH){
            if(map.passable((double)locX, (double)locY-movementInc, this)){
                for(int i = 0; i < units.size(); ++i){
                    if(!(units.get(i).distance((double)centerX, (double)centerY-movementInc))){
                       if(units.get(i)!=this && !(accept.contains(units.get(i)) && this==curr))
                        move = false;
                    }
                }
                if(move){
                    locY-=movementInc;
                    this.centerX = locX + cwidth/2;
                    this.centerY = locY + cheight * 7 / 8;
                }
            }
        }
        else if(direction == DirectionType.WEST){
            if(map.passable((double)locX-movementInc, (double)locY, this)){
                for(int i = 0; i < units.size(); ++i){
                    if(!(units.get(i).distance((double)centerX-movementInc, (double)centerY))){
                       if(units.get(i)!=this && !(accept.contains(units.get(i)) && this==curr))
                        move = false;
                    }
                }
                if(move){
                    locX-=movementInc;
                    this.centerX = locX + cwidth/2;
                    this.centerY = locY + cheight * 7 / 8;
                }
            }
        }
        else if(direction == DirectionType.SOUTH){
            if(map.passable((double)locX, (double)locY+movementInc, this)){
                for(int i = 0; i < units.size(); ++i){
                    if(!(units.get(i).distance((double)centerX, (double)centerY+movementInc))){
                       if(units.get(i)!=this && !(accept.contains(units.get(i)) && this==curr))
                        move = false;
                    }
                }
                if(move){
                    locY+=movementInc;
                    this.centerX = locX + cwidth/2;
                    this.centerY = locY + cheight * 7 / 8;
                }
            }
        }
        System.out.println(name + " moved to " + locX + ", " + locY);
        return move;
    }

    boolean distance(double x, double y){
        double dist = Math.sqrt((this.centerX - x) * (this.centerX - x)
                                + (this.centerY - y) * (this.centerY - y));
        if( dist >= bubble){
            return true;
        }
        return false;
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
    
    public int compareTo(Object o){
        if(o instanceof Character ){
            Character c = (Character) o;
            if(centerY < c.centerY){
                return -1;
            }
            else if (centerY > c.centerY){
                return 1;
            }
            return 0;
        }
        return -500;
    }


    
}
