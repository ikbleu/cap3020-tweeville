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
public class Eventer implements Tickable{
    Eventer(String loadingfile, Model m){
        File file = new File(loadingfile);
        Scanner s;
        try{
            s = new Scanner(file);

        }
        catch(Exception C){
            System.out.println("Problem loading Eventer!");
            System.exit(0);
        }

    }

    public void onTick(){

    }

    private class Move{
        Move(Character c, int goalX, int goalY){

        }
    }

    private class Dialogue{
        Dialogue(String file){

        }
    }
}
