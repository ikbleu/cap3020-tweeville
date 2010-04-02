/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;

/**
 *
 * @author spock
 */
public class BattleModel {
    FightModel fightModel;
    BattleMap battleMap;
    Clock clock;


    BattleModel(File battleInfo, File map){
        fightModel = new FightModel(battleInfo);
        battleMap = new BattleMap(map);
        clock = new Clock(100);
    }
}
