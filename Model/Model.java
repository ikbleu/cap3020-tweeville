/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Mr. Wilmot
 */
public class Model {
    private ModeType mode;
    BattleModel battleModel;
    FreeRoamModel freeRoamModel;
    
    
    public Model(){
        mode = ModeType.SPLASH;
        freeRoamModel = new FreeRoamModel();
        battleModel = new BattleModel();
    }

}
