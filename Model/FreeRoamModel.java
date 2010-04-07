/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author spock
 */
public class FreeRoamModel implements Tickable{

    FreeRoamMap freeRoamMap;
    Scanner s;
    ArrayList<Character> controlled;
    ArrayList<Character> npcs;
    
    Character currentChar;
    int currCharIndex = 0;
    boolean readGood;
    ArrayList<TriggerBox> triggers;
    Model m;


    FreeRoamModel(File freeRoamInfo, File map, Model model){
        m = model;
        freeRoamMap = new FreeRoamMap(map);
        controlled = new ArrayList<Character>();
        npcs = new ArrayList<Character>();
        triggers = new ArrayList<TriggerBox>();
        try{
            s = new Scanner(freeRoamInfo);
        }
        catch(Exception c){
            System.out.println("The loading of the FreeRoamMap failed!");
        }
        while(s.hasNext()){
            String type = s.next();
            System.out.println(type);
            if(type.equals("human")){
                String name = s.next();
                int locX = s.nextInt();
                int locY = s.nextInt();
                int cwidth = s.nextInt();
                int cheight = s.nextInt();
                controlled.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.FRIENDLY, freeRoamMap));
            }
            if(type.equals("trigger")){
                double x1 = s.nextDouble();
                double x2 = s.nextDouble();
                double y1 = s.nextDouble();
                double y2 = s.nextDouble();
                String newType = s.next();
                String newInfo = s.next();
                String newMap = s.next();
                triggers.add(new TriggerBox(x1, x2, y1, y2, newType, newInfo, newMap));
            }
        }
        currentChar = controlled.get(0);
        currCharIndex = 0;
    }

    void charMove(DirectionType direction){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        currentChar.move(direction, yes, controlled, currentChar);
    }

    void swapChar(){
        currCharIndex++;
        if(currCharIndex>=controlled.size()){
            currCharIndex = 0;
        }
        currentChar = controlled.get(currCharIndex);
    }

    public void onTick(){
        
    }

    List<Character> getUnits(){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        for(int i = 0; i < controlled.size()-1; ++ i){
            double x1 = controlled.get(currCharIndex + 1 + i).centerX;
            double x2 = controlled.get(currCharIndex).centerX;
            double y1 = controlled.get(currCharIndex + 1 + i).centerY;
            double y2 = controlled.get(currCharIndex).centerY;
            if ( Math.abs(x1 - x2) > Math.abs(y1 - y2)){
                if(x1 < x2){
                    controlled.get(currCharIndex + 1 + i).move(DirectionType.EAST, yes, controlled, currentChar);
                }
                else{
                    controlled.get(currCharIndex + 1 + i).move(DirectionType.WEST, yes, controlled, currentChar);
                }
            }
            else{
                if(y1 < y2){
                    controlled.get(currCharIndex + 1 + i).move(DirectionType.SOUTH, yes, controlled, currentChar);
                }
                else{
                    controlled.get(currCharIndex + 1 + i).move(DirectionType.NORTH, yes, controlled, currentChar);
                }
            }
        }
        return yes;
    }



}
