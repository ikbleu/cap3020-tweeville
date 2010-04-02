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

    HashMap< String, BufferedImage > graphics;

    private GraphicsTableSingleton(){
        graphics = new HashMap<String, BufferedImage>();
        try{
	    graphics.put( "BattleScreen", ImageIO.read(new File("Images/BattleScreen.png")));
            graphics.put( "BattleScreenViewPort", ImageIO.read(new File("Images/BattleScreenViewPort.png")));
	    graphics.put( "BattleScreenHUD", ImageIO.read(new File("Images/BattleScreenHUD.png")));
            graphics.put( "TestHUD", ImageIO.read(new File("Images/s17.JPG")));
            graphics.put( "Rice", ImageIO.read(new File("Images/rice.jpg")));

	    graphics.put( "NastieS", ImageIO.read(new File("Images/NastieS.png"))); //Nastie standing facing south
        }
        catch(Exception e){
            System.out.println("Image loading failed");
        }
    }

    BufferedImage getGraphic(String key){
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