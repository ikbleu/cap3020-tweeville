/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.util.List;

import Control.Controller;
import View.View;

/**
 *
 * @author Mr. Wilmot
 */
public class Model implements ViewHelper, LeashedModel{
    private ModeType mode;
    BattleModel battleModel;
    FreeRoamModel freeRoamModel;
    File battleModelMap;
    File battleModelFight;
    File freeRoamModelMap;
    File freeRoamModelInfo;
    Clock clock;

   

    View view;
    Controller controller;
    
    
    public Model(){
        mode = ModeType.FREEROAM;
        battleModelMap = new File("Images/BattleScreenColorMap.png");
        battleModelFight = new File("ConfigFiles/BattleInput.txt");
        freeRoamModelInfo = new File ("ConfigFiles/FRInput.txt");
        freeRoamModelMap = new File ("Images/TestMap.png");
        battleModel = new BattleModel(battleModelFight, battleModelMap);
        freeRoamModel = new FreeRoamModel(freeRoamModelInfo, freeRoamModelMap, this);
        clock = new Clock(30);
        register(freeRoamModel);
        /*try{
            ifs = new FileInputStream(new File("Images/AA.mp3"));
            player = new Player(ifs);
            player.play();
            System.out.println("I can do things after i play too!");
        }
        catch(Exception c){
            System.out.println("Oh nos!");
        }*/
    }

    public void setNewFreeRoam(String infoFile, String mapFile){
        freeRoamModelInfo = new File(infoFile);
        freeRoamModelMap = new File(mapFile);
        freeRoamModel = new FreeRoamModel(freeRoamModelInfo, freeRoamModelMap, this);
        register(freeRoamModel);
    }

    public void start(){
        clock.start();
        modeUpdate(mode);
    }

    public void modeUpdateRegister(View v, Controller c){
        view = v;
        controller = c;
    }

    public void unregister(Tickable t){
        clock.removeListener(t);
    }

    public void setMode(ModeType mode){
        this.mode = mode;
        if(mode == ModeType.DIALOGUE){
            controller.setMode(ModeType.DIALOGUE);
            view.setMode(ModeType.DIALOGUE);
        }
        if(mode == ModeType.FREEROAM){
            controller.setMode(ModeType.FREEROAM);
            view.setMode(ModeType.FREEROAM);
        }
    }

    public void action(){
        freeRoamModel.action();
    }

    public void scroll(int di){
        freeRoamModel.scroll(di);
    }

    public void nextDialogue(){
        freeRoamModel.nextDialogue();
    }


    public List<String> getDialogue(){
        return freeRoamModel.getDialogue();
    }

    public int getDialogueSelection(){
        return freeRoamModel.getDialogueSelection();
    }

    public Character getCurrChar(){
        return freeRoamModel.currentChar;
    }

    public void modeUpdate(ModeType mode){
        view.setMode(mode);
        controller.setMode(mode);
    }

    public void moveChar(DirectionType d){
        if(mode == ModeType.BATTLE){
            battleModel.charMove(d);
        }
        if(mode == ModeType.FREEROAM){
            freeRoamModel.charMove(d);
        }
    }

    public void register(Tickable t){
        clock.addListener(t);
    }

    public List<Character> getUnits(){
        if(mode == ModeType.BATTLE){
            return battleModel.getUnits();
        }
        if(mode == ModeType.FREEROAM){
            return freeRoamModel.getUnits();
        }
        return null;
    }
    public WeaponType getBScurrentMelee(){
        return null;
    }
    public WeaponType getBScurrentRanged(){
        return null;
    }
    public WeaponType getBScurrentArmor(){
        return null;
    }
    public int[] getHPs(){
        return null;
    }
    public ViewCooldown[][] getCoolDowns(){
        return null;
    }

    public void chrisWantsToRegister( Tickable t )
    {
	register( t );
    }
}
