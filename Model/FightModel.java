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
import java.util.LinkedList;

/**
 *
 * @author spock
 */
public class FightModel implements Tickable{
    File battle;
    Scanner s;
    ArrayList<Character> good;
    ArrayList<Character> enemy;
    ArrayList<Character> damage;
    Character currentChar;
    int currCharIndex = 0;
    boolean readGood;
    Model model;
    int damageTime;

    boolean endWaiting;

    ArrayList<BattleEventer> damagePattern;



    FightModel(File fmodel, BattleMap map, Model m){
        this.model = m;
        battle = fmodel;
        readGood = true;
        good = new ArrayList<Character>();
        enemy = new ArrayList<Character>();
        damage = new ArrayList<Character>();
        damagePattern = new ArrayList<BattleEventer>();
        endWaiting = false;

        damageTime = 0;
        try{
            s = new Scanner(battle);
        }
        catch(Exception c){
            System.out.println("Couldn't find Fight Model Loader Fail!");
            System.exit(0);
        }
        while(s.hasNext()){
            String type = s.next();
            if(type.equals("good")){
                String name = s.next();
                int locX = s.nextInt();
                int locY = s.nextInt();
                int cwidth = s.nextInt();
                int cheight = s.nextInt();
                good.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.FRIENDLY, map));
            }
            if(type.equals("enemy")){
                String name = s.next();
                int locX = s.nextInt();
                int locY = s.nextInt();
                int cwidth = s.nextInt();
                int cheight = s.nextInt();
                enemy.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.ENEMY, map));
            }
            if(type.equals("damage")){
                String name = s.next();
                int locX = s.nextInt();
                int locY = s.nextInt();
                int cwidth = s.nextInt();
                int cheight = s.nextInt();
                damage.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.ENEMY, map));
            }
            if(type.equals("event")){
                String file = s.next();
                ArrayList<Character> yes = new ArrayList<Character>();
                yes.addAll(enemy);
                yes.addAll(damage);
                damagePattern.add(new BattleEventer(file, model, yes));
            }
        }
        currentChar = good.get(0);
        currCharIndex = 0;
    }

    void move(DirectionType direction, boolean b){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(good);
        yes.addAll(enemy);
        currentChar.move(direction, yes, good, currentChar, b);
    }

    void swapChar(){
        currCharIndex++;
        if(currCharIndex>=good.size()){
            currCharIndex = 0;
        }
        if(good.size()!=0)
            currentChar = good.get(currCharIndex);
    }

    boolean specMove(DirectionType direction, Character c){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(good);
        yes.addAll(enemy);
        return c.move(direction, yes, good, c, false);
    }

    void goodAttack(Character c){
        double cax = 0;
        double cay = 0;
        if(c.direction == DirectionType.EAST){
            cax = c.centerX + c.bubble * 2;
            cay = c.centerY;
            c.setAttackMode();
            model.view.actionMusic();
        }
        else if(c.direction == DirectionType.WEST){
            cax = c.centerX - c.bubble * 2;
            cay = c.centerY;
            c.setAttackMode();
            model.view.actionMusic();
        }
        else if(c.direction == DirectionType.NORTH){
            cax = c.centerX;
            cay = c.centerY - c.bubble * 2;
            c.setAttackMode();
            model.view.actionMusic();
        }
        else if(c.direction == DirectionType.SOUTH){
            cax = c.centerX;
            cay = c.centerY + c.bubble * 2;
            c.setAttackMode();
            model.view.actionMusic();
        }
        for(int i = 0; i < enemy.size(); ++i){
            if(enemy.get(i).attackDistance(cax, cay)){
                enemy.get(i).hp -= 5;
            }
        }
    }


    public void onTick(){

        if(endWaiting){
            if(model.view.transitionDone()){
                model.unregister(this);
                model.setMode(ModeType.FREEROAM);
                model.view.transitionIn();
            }
        }

        for(int i = 0; i < damagePattern.size(); ++i){
            damagePattern.get(i).tick();
        }
        
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(good);
        yes.addAll(enemy);

        ++damageTime;

        ArrayList<Character> no = new ArrayList<Character>();
        no.addAll(damage);
        no.addAll(enemy);

        if(damageTime >= 2){
            damageTime = 0;
            for(int j = 0; j < no.size(); ++j ){
                for(int i = 0; i < good.size(); ++i){
                    if(no.get(j).talkDistance(good.get(i).centerX, good.get(i).centerY)){
                        good.get(i).hp--;
                    }
                }
            }
        }

        LinkedList<Character> removeIf = new LinkedList<Character>();

        for(int i = 0; i < good.size(); ++i){
            if(good.get(i).hp <= 0){
                removeIf.add(good.get(i));
            }
        }

        for(int i = 0; i < removeIf.size(); ++i){
            good.remove(removeIf.get(i));
            if(good.size() == 0){
                model.view.transitionOut();
                endWaiting = true;
            }
            if(removeIf.get(i) == currentChar){
               swapChar();
            }
        }

        removeIf = new LinkedList<Character>();

        for(int i = 0; i < enemy.size(); ++i){
            if(enemy.get(i).hp <= 0){
                removeIf.add(enemy.get(i));
            }
        }

        for(int i = 0; i < removeIf.size(); ++i){
            enemy.remove(removeIf.get(i));
            if(enemy.size() == 0){
                model.view.transitionOut();
                endWaiting = true;
                //model.unregister(this);
                //model.setMode(ModeType.FREEROAM);
            }
        }


        for(int i = 0; i < yes.size();++i){
            yes.get(i).tickCheck();
        }



        if(good.size()!=0){
            for(int i = 0; i < good.size() ; ++ i){
                if(i!= currCharIndex){
                    if(currCharIndex >= 0 && currCharIndex < good.size()){
                        double x1 = good.get(i).centerX;
                        double x2 = good.get(currCharIndex).centerX;
                        double y1 = good.get(i).centerY;
                        double y2 = good.get(currCharIndex).centerY;
                        boolean moved = false;
                        if ( Math.abs(x1 - x2) > Math.abs(y1 - y2)){
                            if(x1 < x2){
                                moved = good.get(i).move(DirectionType.EAST, yes, good, currentChar, false);
                            }
                            else{
                                moved = good.get(i).move(DirectionType.WEST, yes, good, currentChar, false);
                            }
                        }
                        if(!moved){
                            if(y1 < y2){
                                moved = good.get(i).move(DirectionType.SOUTH, yes, good, currentChar, false);
                            }
                            else{
                                moved = good.get(i).move(DirectionType.NORTH, yes, good, currentChar, false);
                            }
                        }
                    }
                }
            }
        }
    }

    List<Character> getUnits(){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(good);
        yes.addAll(enemy);
        yes.addAll(damage);
        return yes;
    }

    Character StringToChar(String name){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(enemy);
        yes.addAll(damage);
        for(int i = 0; i < yes.size();++i){
            if(yes.get(i).name.equals(name)){
                return yes.get(i);
            }
        }
        return null;
    }
    
    

}

