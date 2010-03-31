/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

/**
 *
 * @author spock
 */
public class BattleMap {
    BufferedImage image;
    int okay = (Color.BLUE).getRGB();

    BattleMap(File map){
        try{
            image = ImageIO.read(map);
        }
        catch(Exception e){
            System.out.println("BattleMap Reading Failed!");
            System.exit(0);
        }
    }

    boolean passable(double x, double y){
        return image.getRGB((int)x, (int)y) == okay;
    }

}
