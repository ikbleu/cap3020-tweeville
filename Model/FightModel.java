/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Point;
import java.util.List;

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
    int currCharIndex = 0;
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
                int cwidth = s.nextInt();
                int cheight = s.nextInt();

                if(readGood){
                    good.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.FRIENDLY, map));
                }
                else{
                    enemy.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.ENEMY, map));
                }
            }
        }
        currentChar = good.get(0);
        currCharIndex = 0;
    }

    void move(DirectionType direction){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(good);
        yes.addAll(enemy);
        currentChar.move(direction, yes, good, currentChar);
    }

    void swapChar(){
        currCharIndex++;
        if(currCharIndex>=good.size()){
            currCharIndex = 0;
        }
        currentChar = good.get(currCharIndex);
    }

    List<Character> getUnits(){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(good);
        yes.addAll(enemy);
        return yes;
    }

}
