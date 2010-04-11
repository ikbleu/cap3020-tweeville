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

    public void run() {
        try{
            ifs = new FileInputStream(new File("Images/AA.mp3"));
            player = new Player(ifs);
            player.play();
            System.out.println("I can do things after i play too!");
        }
        catch(Exception c){
            System.out.println("Oh nos!");
        }
    }
}
