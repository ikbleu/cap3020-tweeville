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
public class Eventer implements Tickable{
    Eventee curr;
    int currIndex;
    Model m;
    ArrayList<Eventee> events;
    int tickWait;

    Eventer(String loadingfile, Model m){
        File file = new File(loadingfile);
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
                else if(type.equals("dialogue")){
                    String fName = s.next();
                    events.add(new Dialogue(fName));
                }
            }

        }
        catch(Exception C){
            System.out.println("Problem loading Eventer!");
            System.exit(0);
        }

        currIndex = 0;
        curr = events.get(0);
        /*if(curr instanceof Dialogue){
            m.setMode(ModeType.DIALOGUE);
        }*/
    }

    void start(){
        m.register(this);
        if(curr instanceof Dialogue){
            m.setMode(ModeType.DIALOGUE);
        }
    }


    public void onTick(){
        ++tickWait;
        if(curr.isComplete()){
            ++currIndex;
            System.out.println(currIndex);
            if(currIndex < events.size()){
                curr = events.get(currIndex);
                //m.setMode(ModeType.CUTSCENE);
                if(curr instanceof Dialogue){
                    m.setMode(ModeType.DIALOGUE);
                }
            }
            else{
                m.setMode(ModeType.FREEROAM);
                m.freeRoamModel.eventOn = false;
                m.unregister(this);
            }
        }
        else{
            if(tickWait >= 3){
                tickWait = 0;
                curr.nextCommand();
            }
        }
    }

    public List<String> getDialogue(){
        return ((Dialogue)curr).dHandler.getDialogue();
    }

    public int getDialogueSelection(){
        return ((Dialogue)curr).dHandler.currSelection();
    }

    public void scroll(int di){
        ((Dialogue)curr).dHandler.scroll(di);
    }

    public void next(){
        ((Dialogue)curr).dHandler.next();
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
            this.c = m.freeRoamModel.StringToChar(cName);
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
                    m.freeRoamModel.specMove(DirectionType.EAST, c);
                }
                else{
                    m.freeRoamModel.specMove(DirectionType.WEST, c);
                }
            }
            else{
                if(y1 < y2){
                    m.freeRoamModel.specMove(DirectionType.SOUTH, c);
                }
                else{
                    m.freeRoamModel.specMove(DirectionType.NORTH, c);
                }
            }
        }
    }

    private class Dialogue extends Eventee{

        DialogueHandler dHandler;

        Dialogue(String file){
            dHandler = new DialogueHandler(file);
        }

        boolean isComplete(){
            if(dHandler.done()){
                m.setMode(ModeType.CUTSCENE);
                return true;
            }
            return dHandler.done();
        }

        void nextCommand(){
            
        }

    }
}
