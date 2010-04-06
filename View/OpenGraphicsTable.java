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
            graphics.put( "BattleScreen", TextureIO.newTexture(ImageIO.read(new File("Images/BattleScreen.png")), true));
            graphics.put( "BattleScreenViewPort", TextureIO.newTexture(ImageIO.read(new File("Images/BattleScreenViewPort.png")), true));
            graphics.put( "BattleScreenHUD", TextureIO.newTexture(ImageIO.read(new File("Images/BattleScreenHUD.png")), true));
            graphics.put( "TestHUD", TextureIO.newTexture(ImageIO.read(new File("Images/s17.JPG")), true));
            graphics.put( "Rice", TextureIO.newTexture(ImageIO.read(new File("Images/s17.JPG")), true));
            graphics.put( "NastieS", TextureIO.newTexture(ImageIO.read(new File("Images/NastieS.png")), true));
            graphics.put( "colormap", TextureIO.newTexture(ImageIO.read(new File("Images/BattleScreenColorMap.png")), true));

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
