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
    int movementInc = 15;
    double centerX;
    double centerY;
    double bubble;
    boolean moveCheck;
    int checkCount;
    //1130 x 650
    //36 x 80

    Character(String name, int locX, int locY, int cwidth, int cheight, AllianceType alliance, GameMap map){
        this.name = name;
        this.locX = locX;
        this.locY = locY;
        this.cwidth = cwidth;
        this.cheight = cheight;
        this.status = UnitStatus.SSOUTH;
        this.direction = DirectionType.SOUTH;
        this.alliance = alliance;
        this.map = map;
        this.centerX = locX + cwidth/2;
        this.centerY = locY + cheight * 7 / 8;
        this.bubble = Math.sqrt( (this.centerX - (locX + this.cwidth)) * (this.centerX - (locX + this.cwidth))
                                + (this.centerY - (locY + this.cheight)) * (this.centerY - (locY + this.cheight)) );

        hp = 100;
        this.moveCheck = false;
        this.checkCount = 0;
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
                    moveCheck = true;
                    if(status == UnitStatus.WEAST){
                        status = UnitStatus.SEAST;
                        this.direction = DirectionType.EAST;
                    }
                    else{
                        status = UnitStatus.WEAST;
                        this.direction = DirectionType.EAST;
                    }
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
                    moveCheck = true;
                    if(status == UnitStatus.SNORTH){
                        status = UnitStatus.WNORTH1;
                        this.direction = DirectionType.NORTH;
                    }
                    else if(status == UnitStatus.WNORTH1){
                        status = UnitStatus.WNORTH2;
                        this.direction = DirectionType.NORTH;
                    }
                    else if(status == UnitStatus.WNORTH2){
                        status = UnitStatus.WNORTH1;
                        this.direction = DirectionType.NORTH;
                    }
                    else{
                        status = UnitStatus.WNORTH1;
                        this.direction = DirectionType.NORTH;
                    }
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
                    moveCheck = true;
                    if(status == UnitStatus.WWEST){
                        status = UnitStatus.SWEST;
                        this.direction = DirectionType.WEST;
                    }
                    else{
                        status = UnitStatus.WWEST;
                        this.direction = DirectionType.WEST;
                    }
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
                    moveCheck = true;
                    if(status == UnitStatus.SSOUTH){
                        status = UnitStatus.WSOUTH1;
                        this.direction = DirectionType.SOUTH;
                    }
                    else if(status == UnitStatus.WSOUTH1){
                        status = UnitStatus.WSOUTH2;
                        this.direction = DirectionType.SOUTH;
                    }
                    else if(status == UnitStatus.WSOUTH2){
                        status = UnitStatus.WSOUTH1;
                        this.direction = DirectionType.SOUTH;
                    }
                    else{
                        status = UnitStatus.WSOUTH1;
                        this.direction = DirectionType.SOUTH;
                    }
                }
            }
        }
        //System.out.println(name + " moved to " + locX + ", " + locY);
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

    boolean talkDistance(double x, double y){
        double dist = Math.sqrt((this.centerX - x) * (this.centerX - x)
                                + (this.centerY - y) * (this.centerY - y));
        if( dist <= bubble*2.5){
            return true;
        }
        return false;
    }

    boolean attackDistance(double x, double y){
        double dist = Math.sqrt((this.centerX - x) * (this.centerX - x)
                                + (this.centerY - y) * (this.centerY - y));
        if( dist <= bubble*3.5){
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

    public boolean tickCheck(){
        if(!moveCheck){
            checkCount++;
        }
        else{
            checkCount = 0;
        }

        moveCheck = false;

        if(checkCount == 5){
            checkCount = 0;
            if(direction == DirectionType.SOUTH){
                status = UnitStatus.SSOUTH;
            }
            else if(direction == DirectionType.WEST){
                status = UnitStatus.SWEST;
            }
            else if(direction == DirectionType.NORTH){
                status = UnitStatus.SNORTH;
            }
            else if(direction == DirectionType.EAST){
                status = UnitStatus.SEAST;
            }
            return moveCheck;
        }

        return true;
    }


    
}
