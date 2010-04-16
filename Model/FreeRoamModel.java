/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

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
    ArrayList<TriggerBox> returners;
    Model m;

    Eventer currentEvent;

    DialogueHandler dHandler;
    boolean dialogueOn;

    boolean eventOn;

    boolean frTriggerWaiting;
    boolean bTriggerWaiting;
    TriggerBox waitingTrigger;

    HashMap<String, DialogueHandler> dialogueSet;

    FreeRoamModel(File freeRoamInfo, File map, Model model){
        m = model;
        freeRoamMap = new FreeRoamMap(map);
        controlled = new ArrayList<Character>();
        npcs = new ArrayList<Character>();
        triggers = new ArrayList<TriggerBox>();
        returners = new ArrayList<TriggerBox>();
        dialogueOn = false;
        eventOn = false;

        frTriggerWaiting = false;
        bTriggerWaiting = false;
        waitingTrigger = null;

        dialogueSet = new HashMap<String, DialogueHandler>();
        //dHandler = new DialogueHandler("ConfigFiles/DialogueTest.txt");
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
            if(type.equals("npc")){
                String name = s.next();
                int locX = s.nextInt();
                int locY = s.nextInt();
                int cwidth = s.nextInt();
                int cheight = s.nextInt();
                npcs.add(new Character(name, locX, locY, cwidth, cheight, AllianceType.FRIENDLY, freeRoamMap));
            }
            if(type.equals("trigger")){
                double x1 = s.nextDouble();
                double x2 = s.nextDouble();
                double y1 = s.nextDouble();
                double y2 = s.nextDouble();
                String newType = s.next();
                String newInfo = s.next();
                String newMap = s.next();
                String viewInfo = s.next();
                triggers.add(new TriggerBox(x1, x2, y1, y2, newType, newInfo, newMap, viewInfo));
            }
            if(type.equals("dialogue")){
                String name = s.next();
                String loader = s.next();
                dialogueSet.put(name, new DialogueHandler(loader));
            }
        }
        currentChar = controlled.get(0);
        currCharIndex = 0;
    }

    boolean charMove(DirectionType direction, boolean b){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        return currentChar.move(direction, yes, controlled, currentChar, b);
    }

    boolean specMove(DirectionType direction, Character c){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        return c.move(direction, yes, controlled, c, false);
    }

    Character StringToChar(String name){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        for(int i = 0; i < yes.size();++i){
            if(yes.get(i).name.equals(name)){
                return yes.get(i);
            }
        }
        return null;
    }

    void swapChar(){
        currCharIndex++;
        if(currCharIndex>=controlled.size()){
            currCharIndex = 0;
        }
        currentChar = controlled.get(currCharIndex);
    }

    void action(){
        for(int i = 0; i < npcs.size(); ++i){
            if(npcs.get(i).talkDistance(currentChar.centerX, currentChar.centerY) && dialogueSet.containsKey(npcs.get(i).name)){
                dHandler = dialogueSet.get(npcs.get(i).name);
                dialogueOn = true;
                m.setMode(ModeType.DIALOGUE);
            }
        }
    }

    void scroll(int di){
        if(eventOn){
            currentEvent.scroll(di);
        }
        if(dialogueOn){
            dHandler.scroll(di);
        }
    }

    void nextDialogue(){
        if(eventOn){
            currentEvent.next();
        }
        if(dialogueOn){
            dHandler.next();
        }
    }
 
    List<String> getDialogue(){
        if(eventOn){
            return currentEvent.getDialogue();
        }
        return dHandler.getDialogue();
    }

    int getDialogueSelection(){
        if(eventOn){
            return currentEvent.getDialogueSelection();
        }
        return dHandler.currSelection();
    }

    public void onTick(){
        if(frTriggerWaiting){
            if(m.view.transitionDone()){
                frTriggerWaiting = false;
                m.unregister(this);
                m.setNewFreeRoam(waitingTrigger.loadingInfoFile, waitingTrigger.loadingMapFile, waitingTrigger.viewInfo);
            }
        }
        if(bTriggerWaiting){
            if(m.view.transitionDone()){
                bTriggerWaiting = false;
                m.setNewBattle( waitingTrigger.loadingInfoFile, waitingTrigger.loadingMapFile, waitingTrigger.viewInfo);
            }
        }
        
        int retRem = -1;
        for(int i = 0; i < returners.size(); ++i){
            if(!(returners.get(i).inside(controlled.get(currCharIndex).centerX, controlled.get(currCharIndex).centerY))){
                triggers.add(returners.get(i));
                retRem = i;
            }
        }
        if(retRem != -1){
            returners.remove(retRem);
        }

        if(dialogueOn && dHandler.done()){
            dialogueOn = false;
            m.setMode(ModeType.FREEROAM);
        }
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        
        for(int i = 0; i < yes.size();++i){
            yes.get(i).tickCheck();
        }
        int triggerRemoval = -1;

        for(int i = 0; i < triggers.size(); ++i){
            if(triggers.get(i).inside(controlled.get(currCharIndex).centerX, controlled.get(currCharIndex).centerY)){
                if(triggers.get(i).triggerType.equals("FreeRoam")){
                    //m.unregister(this);
                    //m.setNewFreeRoam(triggers.get(i).loadingInfoFile, triggers.get(i).loadingMapFile, triggers.get(i).viewInfo);
                    frTriggerWaiting = true;
                    waitingTrigger = triggers.get(i);
                    m.view.transitionOut();
                    triggerRemoval = i;
                }
                if(triggers.get(i).triggerType.equals("EventS")){
                    //move
                    //dialogue
                    currentEvent = new Eventer(triggers.get(i).loadingInfoFile, m);
                    m.setMode(ModeType.CUTSCENE);
                    currentEvent.start();
                    eventOn = true;
                    returners.add(triggers.get(i));
                    triggerRemoval = i;
                }
                if(triggers.get(i).triggerType.equals("Event")){
                    currentEvent = new Eventer(triggers.get(i).loadingInfoFile, m);
                    m.setMode(ModeType.CUTSCENE);
                    currentEvent.start();
                    eventOn = true;
                    triggerRemoval = i;
                }
                if(triggers.get(i).triggerType.equals("Battle")){
                    bTriggerWaiting = true;
                    waitingTrigger = triggers.get(i);
                    m.view.transitionOut();
                    triggerRemoval = i;
                }
            }
        }

        if(triggerRemoval != -1){
            triggers.remove(triggerRemoval);
        }


        for(int i = 0; i < controlled.size(); ++ i){
            if(i!= currCharIndex){
                double x1 = controlled.get(i).centerX;
                double x2 = controlled.get(currCharIndex).centerX;
                double y1 = controlled.get(i).centerY;
                double y2 = controlled.get(currCharIndex).centerY;
                boolean moved = false;
                boolean tester = (x1-x2 + y1-y2>currentChar.bubble*2 && Math.abs((x1-x2)-(y1-y2))<currentChar.bubble) || (m.dia);
                if(Math.abs(x1 - x2) <= Math.abs(y1 - y2)){
                    if(y1 < y2){
                        moved = controlled.get(i).move(DirectionType.SOUTH, yes, controlled, currentChar, tester);
                    }
                    else{
                        moved = controlled.get(i).move(DirectionType.NORTH, yes, controlled, currentChar, tester);
                    }
                }
                if ( !moved){
                    if(x1 < x2){
                        moved = controlled.get(i).move(DirectionType.EAST, yes, controlled, currentChar, tester);
                    }
                    else{
                        moved = controlled.get(i).move(DirectionType.WEST, yes, controlled, currentChar, tester);
                    }
                }
                /*if(!moved){
                    if(y1 < y2){
                        moved = controlled.get(i).move(DirectionType.SOUTH, yes, controlled, currentChar, tester);
                    }
                    else{
                        moved = controlled.get(i).move(DirectionType.NORTH, yes, controlled, currentChar, tester);
                    }
                }*/
            }
        }
    }

    List<Character> getUnits(){
        ArrayList<Character> yes = new ArrayList<Character>();
        yes.addAll(controlled);
        yes.addAll(npcs);
        return yes;
    }



}
