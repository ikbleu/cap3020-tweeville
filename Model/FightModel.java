/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author spock
 */
public class FightModel {
    File battle;
    Scanner s;
    Character[] good;
    Character[] enemy;



    FightModel(File model){
        battle = model;
        try{
            s = new Scanner(battle);
        }
        catch(Exception c){
            System.out.println("Couldn't find Fight Model Loader Fail!");
            System.exit(0);
        }
        while(s.hasNext()){

        }
    }

}
