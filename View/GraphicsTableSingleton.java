/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;


import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.io.File;
import javax.imageio.ImageIO;


/**
 *
 * @author spock
 */
class GraphicsTableSingleton {

    HashMap< Enum, BufferedImage > graphics;

    private GraphicsTableSingleton(){
        graphics = new HashMap<Enum, BufferedImage>();
        try{
            graphics.put(ViewableEnums.RICE, ImageIO.read(new File("Images/rice.jpg")));
        }
        catch(Exception e){
            System.out.println("Image loading failed");
        }
    }

    BufferedImage getGraphic(Enum key){
        return graphics.get(key);
    }
    private static class GraphicsTableSingletonHolder {
        private static final GraphicsTableSingleton ONEANDONLY =
                                            new GraphicsTableSingleton();
    }

    public static GraphicsTableSingleton getInstance() {
        return GraphicsTableSingletonHolder.ONEANDONLY;
    }
}