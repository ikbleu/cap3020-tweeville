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
	    graphics.put( "DialogueBox", TextureIO.newTexture(ImageIO.read(new File("Images/DialogueBox.png")), true));

            Texture fire = TextureIO.newTexture(ImageIO.read(new File("Images/ball.png")), true);
            graphics.put( "Fire201", fire);
            graphics.put( "Fire202", fire);
            graphics.put( "Fire203", fire);
            graphics.put( "Fire204", fire);
            graphics.put( "Fire205", fire);
            graphics.put( "Fire206", fire);
            graphics.put( "Fire207", fire);
            graphics.put( "Fire208", fire);
            graphics.put( "Fire209", fire);
            graphics.put( "Fire210", fire);

            graphics.put( "Fire301", fire);
            graphics.put( "Fire302", fire);
            graphics.put( "Fire303", fire);
            graphics.put( "Fire304", fire);
            graphics.put( "Fire305", fire);
            graphics.put( "Fire306", fire);
            graphics.put( "Fire307", fire);
            graphics.put( "Fire308", fire);
            graphics.put( "Fire309", fire);
            graphics.put( "Fire310", fire);

            graphics.put( "Fire01", fire);
            graphics.put( "Fire02", fire);
            graphics.put( "Fire03", fire);
            graphics.put( "Fire04", fire);
            graphics.put( "Fire05", fire);
            graphics.put( "Fire06", fire);
            graphics.put( "Fire07", fire);
            graphics.put( "Fire08", fire);
            graphics.put( "Fire09", fire);
            graphics.put( "Fire10", fire);

            graphics.put( "SplashScreen", TextureIO.newTexture(ImageIO.read(new File("Images/SplashScreen.png")), true));
            graphics.put( "black", TextureIO.newTexture(ImageIO.read(new File("Images/BlackImage.png")), true));
            
            /*graphics.put( "map1", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/NW.png")), true));
            graphics.put( "map2", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/N.png")), true));
            graphics.put( "map3", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/NE.png")), true));
            graphics.put( "map4", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/W.png")), true));
            graphics.put( "map5", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/Center.png")), true));
            graphics.put( "map6", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/E.png")), true));
            graphics.put( "map7", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/SW.png")), true));
            graphics.put( "map8", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/S.png")), true));
            graphics.put( "map9", TextureIO.newTexture(ImageIO.read(new File("Images/TestMap/SE.png")), true));*/

            graphics.put( "corridor1", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/NW.png")), true));
            graphics.put( "corridor2", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/N.png")), true));
            graphics.put( "corridor3", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/NE.png")), true));
            graphics.put( "corridor4", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/W.png")), true));
            graphics.put( "corridor5", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/Center.png")), true));
            graphics.put( "corridor6", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/E.png")), true));
            graphics.put( "corridor7", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/SW.png")), true));
            graphics.put( "corridor8", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/S.png")), true));
            graphics.put( "corridor9", TextureIO.newTexture(ImageIO.read(new File("Images/Corridor/SE.png")), true));

            graphics.put( "library1", TextureIO.newTexture(ImageIO.read(new File("Images/Library/NW.png")), true));
            graphics.put( "library2", TextureIO.newTexture(ImageIO.read(new File("Images/Library/N.png")), true));
            graphics.put( "library3", TextureIO.newTexture(ImageIO.read(new File("Images/Library/NE.png")), true));
            graphics.put( "library4", TextureIO.newTexture(ImageIO.read(new File("Images/Library/W.png")), true));
            graphics.put( "library5", TextureIO.newTexture(ImageIO.read(new File("Images/Library/Center.png")), true));
            graphics.put( "library6", TextureIO.newTexture(ImageIO.read(new File("Images/Library/E.png")), true));
            graphics.put( "library7", TextureIO.newTexture(ImageIO.read(new File("Images/Library/SW.png")), true));
            graphics.put( "library8", TextureIO.newTexture(ImageIO.read(new File("Images/Library/S.png")), true));
            graphics.put( "library9", TextureIO.newTexture(ImageIO.read(new File("Images/Library/SE.png")), true));

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

            graphics.put( "Toi01", TextureIO.newTexture(ImageIO.read(new File("Images/Toi01.png")), true));
            graphics.put( "Toi02", TextureIO.newTexture(ImageIO.read(new File("Images/Toi02.png")), true));
            graphics.put( "Toi03", TextureIO.newTexture(ImageIO.read(new File("Images/Toi03.png")), true));
            graphics.put( "Toi04", TextureIO.newTexture(ImageIO.read(new File("Images/Toi04.png")), true));
            graphics.put( "Toi05", TextureIO.newTexture(ImageIO.read(new File("Images/Toi05.png")), true));
            graphics.put( "Toi06", TextureIO.newTexture(ImageIO.read(new File("Images/Toi06.png")), true));
            graphics.put( "Toi08", TextureIO.newTexture(ImageIO.read(new File("Images/Toi07.png")), true));
            graphics.put( "Toi07", TextureIO.newTexture(ImageIO.read(new File("Images/Toi08.png")), true));
            graphics.put( "Toi10", TextureIO.newTexture(ImageIO.read(new File("Images/Toi09.png")), true));
            graphics.put( "Toi09", TextureIO.newTexture(ImageIO.read(new File("Images/Toi10.png")), true));


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
