/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;

/**
 *
 * @author Mr. Wilmot
 */
public class Model implements ViewHelper{
    private ModeType mode;
    BattleModel battleModel;
    FreeRoamModel freeRoamModel;
    File battleModelMap;
    File battleModelFight;
    Clock clock;
    
    
    public Model(){
        mode = ModeType.SPLASH;
        battleModelMap = new File("Images/BattleScreenColorMap.png");
        battleModelFight = new File("ConfigFiles/testBattleFight.txt");
        //freeRoamModel = new FreeRoamModel();
        battleModel = new BattleModel(battleModelFight, battleModelMap);
        clock = new Clock(100);
        clock.start();
    }

    public Viewable[] getUnits(){
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
