/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

import java.io.File;

/**
 *
 * @author spock
 */
public class FreeRoamMap implements GameMap{
    BufferedImage image;
    int okay = (Color.BLUE).getRGB();

    FreeRoamMap(File map){
        try{
            image = ImageIO.read(map);
        }
        catch(Exception e){
            System.out.println("FreeRoam Reading Failed!");
            System.exit(0);
        }
    }

    public boolean passable(double x, double y, Character c){
        if(image.getRGB((int)x, (int)y + c.cheight * 3 / 4) == okay &&
           image.getRGB((int)x, (int)y + c.cheight) == okay &&
           image.getRGB((int)x + c.cwidth, (int)y + c.cheight) == okay &&
           image.getRGB((int)x + c.cwidth, (int)y + c.cheight * 3 / 4) == okay )
            return true;
        else{
            return false;
        }
    }
}
