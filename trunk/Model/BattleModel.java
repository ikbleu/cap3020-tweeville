/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author spock
 */
public class BattleModel {
    FightModel fightModel;
    BattleMap battleMap;
    Clock clock;

    BattleModel(){
        fightModel = new FightModel();
        battleMap = new BattleMap();
        clock = new Clock();
    }

}
