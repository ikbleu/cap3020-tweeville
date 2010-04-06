/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.util.List;

/**
 *
 * @author spock
 */
public class BattleModel {
    FightModel fightModel;
    BattleMap battleMap;
    Clock clock;




    BattleModel(File battleInfo, File map){
        
        battleMap = new BattleMap(map);
        fightModel = new FightModel(battleInfo, battleMap);

    }

    List<Character> getUnits(){
        return fightModel.getUnits();
    }

    void charMove(DirectionType d){
        fightModel.move(d);
    }
}
