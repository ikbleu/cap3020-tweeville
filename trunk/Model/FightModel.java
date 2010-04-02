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
        good = new ArrayList<Character>();
        enemy = new ArrayList<Character>();
        try{
            s = new Scanner(battle);
        }
        catch(Exception c){
            System.out.println("Couldn't find Fight Model Loader Fail!");
            System.exit(0);
        }
        while(s.hasNext()){
            String name = s.next();
            System.out.println(name);
            if(name.equals("evil")){
                readGood = false;
            }
            else{
                int locX = s.nextInt();
                System.out.println(locX);
                int locY = s.nextInt();
                System.out.println(locY);

                if(readGood){
                    good.add(new Character(name, locX, locY, AllianceType.FRIENDLY));
                }
                else{
                    enemy.add(new Character(name, locX, locY, AllianceType.ENEMY));
                }
            }

        }
    }

}
