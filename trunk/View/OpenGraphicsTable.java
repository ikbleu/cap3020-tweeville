/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;

import java.io.File;
import javax.imageio.ImageIO;

import java.util.HashMap;

/**
 *
 * @author spock
 */
public class OpenGraphicsTable {

    HashMap< String, Texture > graphics;

    private OpenGraphicsTable(){
        graphics = new HashMap<String, Texture>();
        try{
            graphics.put( "BattleViewPort", TextureIO.newTexture(ImageIO.read(new File("Images/BattleViewPort.png")), true));
            graphics.put( "BattleHUDBackground", TextureIO.newTexture(ImageIO.read(new File("Images/BattleScreenHUD.png")), true));
	    graphics.put( "BattleHUDBarCapsule", TextureIO.newTexture(ImageIO.read(new File("Images/BattleHUDBarCapsule.png")), true));
	    graphics.put( "BattleBarCapsuleOverlay", TextureIO.newTexture(ImageIO.read(new File("Images/BattleBarCapsuleOverlay.png")), true));
            graphics.put( "TestHUD", TextureIO.newTexture(ImageIO.read(new File("Images/s17.JPG")), true));
            graphics.put( "NastieS", TextureIO.newTexture(ImageIO.read(new File("Images/NastieS.png")), true));
            graphics.put( "Friend", TextureIO.newTexture(ImageIO.read(new File("Images/NastieS.png")), true));
	    graphics.put( "colormap", TextureIO.newTexture(ImageIO.read(new File("Images/BattleScreenColorMap.png")), true));

            graphics.put( "SplashScreen", TextureIO.newTexture(ImageIO.read(new File("Images/SplashScreen.png")), true));
            
            graphics.put( "map1", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/NW.png")), true));
            graphics.put( "map2", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/N.png")), true));
            graphics.put( "map3", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/NE.png")), true));
            graphics.put( "map4", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/W.png")), true));
            graphics.put( "map5", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/Center.png")), true));
            graphics.put( "map6", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/E.png")), true));
            graphics.put( "map7", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/SW.png")), true));
            graphics.put( "map8", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/S.png")), true));
            graphics.put( "map9", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/SE.png")), true));


        }
        catch(Exception e){
            System.out.println("Open GL Image loading failed");
        }
    }

    Texture getGraphic(String key){
        return graphics.get(key);
    }
    private static class OpenGraphicsTableHolder {
        private static final OpenGraphicsTable ONEANDONLY =
                                            new OpenGraphicsTable();
    }

    public static OpenGraphicsTable getInstance() {
        return OpenGraphicsTableHolder.ONEANDONLY;
    }

}
