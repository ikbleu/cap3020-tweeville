/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author spock
 */
public class BattleEventer{
    Eventee curr;
    int currIndex;
    Model m;
    ArrayList<Eventee> events;
    int tickWait;
    ArrayList<Character> charz;

    BattleEventer(String loadingfile, Model m, ArrayList<Character> charz){
        File file = new File(loadingfile);
        this.charz = charz;
        Scanner s;
        this.m = m;
        tickWait = 0;
        events = new ArrayList<Eventee>();
        try{
            s = new Scanner(file);
            while(s.hasNext()){
                String type = s.next();
                if(type.equals("move")){
                    String name = s.next();
                    double gx = s.nextDouble();
                    double gy = s.nextDouble();
                    events.add(new Move(name, gx, gy));
                }
            }

        }
        catch(Exception C){
            System.out.println("Problem loading BattleEventer!");
            System.exit(0);
        }

        currIndex = 0;
        curr = events.get(0);
    }

    public void tick(){
        ++tickWait;
        if(curr.isComplete()){
            ++currIndex;
            System.out.println(currIndex);
            if(currIndex < events.size()){
                curr = events.get(currIndex);
            }
            else{
                currIndex = 0;
                curr = events.get(0);
            }
        }
        else{
            if(tickWait >= 3){
                tickWait = 0;
                curr.nextCommand();
            }
        }
    }

    Character stringToChar(String name){

        for(int i = 0; i < charz.size();++i){
            if(charz.get(i).name.equals(name)){
                System.out.println(name);
                return charz.get(i);
            }
        }
        return null;
    }



    private abstract class Eventee{
        abstract boolean isComplete();
        abstract void nextCommand();
    }

    private class Move extends Eventee{
        Character c;
        double goalX;
        double goalY;


        Move(String cName, double goalX, double goalY){
            this.c = stringToChar(cName);
            this.goalX = goalX;
            this.goalY = goalY;
        }

        boolean isComplete(){
            return c.talkDistance(goalX, goalY);
        }

        void nextCommand(){
            //c.move(events, events, events, curr);

            //implement the movement decision the same way here except use the gaol as the currchar
            double x1 = c.centerX;
            double x2 = goalX;
            double y1 = c.centerY;
            double y2 = goalY;
            if ( Math.abs(x1 - x2) > Math.abs(y1 - y2)){
                if(x1 < x2){
                    m.battleModel.fightModel.specMove(DirectionType.EAST, c);
                }
                else{
                    m.battleModel.fightModel.specMove(DirectionType.WEST, c);
                }
            }
            else{
                if(y1 < y2){
                    m.battleModel.fightModel.specMove(DirectionType.SOUTH, c);
                }
                else{
                    m.battleModel.fightModel.specMove(DirectionType.NORTH, c);
                }
            }
        }
    }

}
