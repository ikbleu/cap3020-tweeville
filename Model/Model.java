/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.util.List;

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
    Clock clock;
    
    
    public Model(){
        mode = ModeType.BATTLE;
        battleModelMap = new File("Images/BattleScreenColorMap.png");
        battleModelFight = new File("ConfigFiles/BattleInput.txt");
        //freeRoamModel = new FreeRoamModel();
        battleModel = new BattleModel(battleModelFight, battleModelMap);
        clock = new Clock(30);
    }

    public void start(){
        clock.start();
    }

    public void moveChar(DirectionType d){
        if(mode == ModeType.BATTLE){
            battleModel.charMove(d);
        }
    }

    public void register(Tickable t){
        clock.addListener(t);
    }

    public List<Viewable> getUnits(){
        if(mode == ModeType.BATTLE){
            return battleModel.getUnits();
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
}
