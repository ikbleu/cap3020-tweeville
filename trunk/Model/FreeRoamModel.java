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
public class FreeRoamModel {

    FreeRoamMap freeRoamMap;
    Scanner s;
    ArrayList<Character> controlled;
    ArrayList<Character> npcs;
    
    Character currentChar;
    int currCharIndex = 0;
    boolean readGood;


    FreeRoamModel(File freeRoamInfo, File map){
        freeRoamMap = new FreeRoamMap(map);
        controlled = new ArrayList<Character>();
        npcs = new ArrayList<Character>();
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
                System.out.println(locX);
                int locY = s.nextInt();
                System.out.println(locY);
                int cwidth = s.nextInt();
                int cheight = s.nextInt();
                controlled.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.FRIENDLY, freeRoamMap));
            }
        }
        currentChar = controlled.get(0);
        currCharIndex = 0;
    }

    void charMove(DirectionType direction){
        currentChar.move(direction);
    }

    void swapChar(){
        currCharIndex++;
        if(currCharIndex>=controlled.size()){
            currCharIndex = 0;
        }
        currentChar = controlled.get(currCharIndex);
    }

    List<Viewable> getUnits(){
        ArrayList<Viewable> yes = new ArrayList<Viewable>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        return yes;
    }



}
