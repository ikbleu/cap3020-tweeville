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

            graphics.put( "Nast01", TextureIO.newTexture(ImageIO.read(new File("Images/Nast01.png")), true));
            graphics.put( "Nast02", TextureIO.newTexture(ImageIO.read(new File("Images/Nast02.png")), true));
            graphics.put( "Nast03", TextureIO.newTexture(ImageIO.read(new File("Images/Nast03.png")), true));
            graphics.put( "Nast04", TextureIO.newTexture(ImageIO.read(new File("Images/Nast04.png")), true));
            graphics.put( "Nast05", TextureIO.newTexture(ImageIO.read(new File("Images/Nast05.png")), true));
            graphics.put( "Nast06", TextureIO.newTexture(ImageIO.read(new File("Images/Nast06.png")), true));
            graphics.put( "Nast07", TextureIO.newTexture(ImageIO.read(new File("Images/Nast07.png")), true));
            graphics.put( "Nast08", TextureIO.newTexture(ImageIO.read(new File("Images/Nast08.png")), true));
            graphics.put( "Nast09", TextureIO.newTexture(ImageIO.read(new File("Images/Nast09.png")), true));
            graphics.put( "Nast10", TextureIO.newTexture(ImageIO.read(new File("Images/Nast10.png")), true));

            graphics.put( "Gunderson01", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson01.png")), true));
            graphics.put( "Gunderson02", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson02.png")), true));
            graphics.put( "Gunderson03", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson03.png")), true));
            graphics.put( "Gunderson04", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson04.png")), true));
            graphics.put( "Gunderson05", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson05.png")), true));
            graphics.put( "Gunderson06", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson06.png")), true));
            graphics.put( "Gunderson07", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson07.png")), true));
            graphics.put( "Gunderson08", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson08.png")), true));
            graphics.put( "Gunderson09", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson09.png")), true));
            graphics.put( "Gunderson10", TextureIO.newTexture(ImageIO.read(new File("Images/Gunderson10.png")), true));


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
