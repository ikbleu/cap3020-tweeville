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
public class Model {
    private ModeType mode;
    BattleModel battleModel;
    FreeRoamModel freeRoamModel;
    File battleModelMap;
    File battleModelFight;
    
    
    public Model(){
        mode = ModeType.SPLASH;
        battleModelMap = new File("testBattleMap.jpg");
        battleModelFight = new File("testBattleFight.txt");
        freeRoamModel = new FreeRoamModel();
        battleModel = new BattleModel(battleModelFight, battleModelMap);
    }

}
