/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Point;

/**
 *
 * @author spock
 */
public class FightModel {
    File battle;
    Scanner s;
    ArrayList<Character> good;
    ArrayList<Character> enemy;
    Character currentChar;
    boolean readGood;



    FightModel(File model, BattleMap map){
        battle = model;
        readGood = true;
        try{
            s = new Scanner(battle);
        }
        catch(Exception c){
            System.out.println("Couldn't find Fight Model Loader Fail!");
            //System.exit(0);
        }
        while(s.hasNext()){
            String name = s.next();
            if(name.equals("evil")){
                readGood = false;
            }
            else{
                int locX = s.nextInt();
                int locY = s.nextInt();

                if(readGood){
                    good.add(new Character(name, new Point(locX, locY), AllianceType.FRIENDLY));
                }
            }

        }
    }

}
