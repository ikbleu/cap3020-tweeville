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
    ModeType mode;
    BattleModel battleModel;
    FreeRoamModel freeRoamModel;
    File battleModelMap;
    File battleModelFight;
    File freeRoamModelMap;
    File freeRoamModelInfo;
    Clock clock;
    boolean dia;

   

    View view;
    Controller controller;
    
    
    public Model(){
        mode = ModeType.FREEROAM;
        freeRoamModelInfo = new File ("ConfigFiles/LibraryInput.txt");
        freeRoamModelMap = new File ("Images/LibraryColorMap.png");
        //battleModel = new BattleModel(battleModelFight, battleModelMap);
        freeRoamModel = new FreeRoamModel(freeRoamModelInfo, freeRoamModelMap, this);
        dia = false;
        clock = new Clock(60);
        register(freeRoamModel);
    }

    public void setDia(boolean d){
        dia = d;
    }

    public void setNewBattle(String infoFile, String mapFile, String viewInfo){
        battleModelFight = new File(infoFile);
        battleModelMap = new File(mapFile);
        battleModel = new BattleModel(battleModelFight, battleModelMap, this);
        setMode(ModeType.BATTLE);
        view.setBMap(viewInfo);
        register(battleModel.fightModel);
        view.transitionOutRealOff();
    }

    public void setNewFreeRoam(String infoFile, String mapFile, String viewInfo){
        freeRoamModelInfo = new File(infoFile);
        freeRoamModelMap = new File(mapFile);
        freeRoamModel = new FreeRoamModel(freeRoamModelInfo, freeRoamModelMap, this);
        view.setFRMap(viewInfo);
        register(freeRoamModel);
        view.transitionOutRealOff();
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
        if(mode == ModeType.CUTSCENE){
            controller.setMode(ModeType.CUTSCENE);
            view.setMode(ModeType.CUTSCENE);
        }
        if(mode == ModeType.BATTLE){
            controller.setMode(ModeType.BATTLE);
            view.setMode(ModeType.BATTLE);
        }
    }

    public void swapChar(){
        if(mode == ModeType.FREEROAM){
            freeRoamModel.swapChar();
        }
        if(mode == ModeType.BATTLE){
            battleModel.fightModel.swapChar();
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
        if(mode == ModeType.FREEROAM || mode == ModeType.CUTSCENE){
            return freeRoamModel.currentChar;
        }
        if(mode == ModeType.BATTLE){
            return battleModel.fightModel.currentChar;
        }
        return null;
    }

    public void attack(){
        battleModel.fightModel.goodAttack(battleModel.fightModel.currentChar);
    }

    public void modeUpdate(ModeType mode){
        view.setMode(mode);
        controller.setMode(mode);
    }

    public void moveChar(DirectionType d, boolean b){
        if(mode == ModeType.BATTLE){
            battleModel.charMove(d, b);
        }
        if(mode == ModeType.FREEROAM || mode == ModeType.CUTSCENE){
            freeRoamModel.charMove(d, b);
        }
    }

    public void register(Tickable t){
        clock.addListener(t);
    }

    public List<Character> getUnits(){
        if(mode == ModeType.BATTLE){
            return battleModel.getUnits();
        }
        if(mode == ModeType.FREEROAM || mode == ModeType.CUTSCENE){
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
