/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.io.FileInputStream;
import javazoom.jl.player.Player;
import java.io.File;

/**
 *
 * @author spock
 */
public class Audio implements Runnable{

    FileInputStream ifs;
    Player player;

    public Audio(String aName){
        try{
            ifs = new FileInputStream(new File(aName));
            player = new Player(ifs);
        }
        catch(Exception c){
            System.out.println("Oh nos Audio fail!");
        }
    }

    public void run() {
        try{
            player.play();
            if(!player.isComplete()){
                //player.close();
                return;
            }
        }
        catch(Exception c){
            System.out.println("Oh nos Audio fail!");
        }
    }

    public boolean isComplete(){
        return player.isComplete();
    }

    public void stop(){
        player.close();
    }
}
