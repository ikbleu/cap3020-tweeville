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
            
            Texture corn1 = TextureIO.newTexture(ImageIO.read(new File("Images/Corn01.png")), true);
            Texture corn2 = TextureIO.newTexture(ImageIO.read(new File("Images/Corn02.png")), true);
            
            graphics.put( "Corn01", corn1);
            graphics.put( "Corn02", corn1);
            graphics.put( "Corn03", corn1);
            graphics.put( "Corn04", corn2);
            graphics.put( "Corn05", corn2);
            graphics.put( "Corn06", corn2);
            graphics.put( "Corn07", corn1);
            graphics.put( "Corn08", corn1);
            graphics.put( "Corn09", corn2);
            graphics.put( "Corn10", corn2);

            Texture turnip1 = TextureIO.newTexture(ImageIO.read(new File("Images/Turnip01.png")), true);
            Texture turnip2 = TextureIO.newTexture(ImageIO.read(new File("Images/Turnip02.png")), true);
            Texture turnip3 = TextureIO.newTexture(ImageIO.read(new File("Images/Turnip03.png")), true);

            graphics.put( "Turnip01", turnip1);
            graphics.put( "Turnip02", turnip1);
            graphics.put( "Turnip03", turnip1);
            graphics.put( "Turnip04", turnip1);
            graphics.put( "Turnip05", turnip1);
            graphics.put( "Turnip06", turnip1);
            graphics.put( "Turnip07", turnip2);
            graphics.put( "Turnip08", turnip2);
            graphics.put( "Turnip09", turnip3);
            graphics.put( "Turnip10", turnip3);


            graphics.put( "SplashScreen", TextureIO.newTexture(ImageIO.read(new File("Images/SplashScreen.png")), true));
            graphics.put( "black", TextureIO.newTexture(ImageIO.read(new File("Images/BlackImage.png")), true));

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

            graphics.put( "NPC01", TextureIO.newTexture(ImageIO.read(new File("Images/NPC01.png")), true));

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
            graphics.put( "Nast11", TextureIO.newTexture(ImageIO.read(new File("Images/NastAtkE.png")), true));
            graphics.put( "Nast12", TextureIO.newTexture(ImageIO.read(new File("Images/NastAtkW.png")), true));
            graphics.put( "Nast13", TextureIO.newTexture(ImageIO.read(new File("Images/NastAtkN.png")), true));
            graphics.put( "Nast14", TextureIO.newTexture(ImageIO.read(new File("Images/NastAtkS.png")), true));

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
            graphics.put( "Gunderson11", TextureIO.newTexture(ImageIO.read(new File("Images/GundersonFight04.png")), true));
            graphics.put( "Gunderson12", TextureIO.newTexture(ImageIO.read(new File("Images/GundersonFight03.png")), true));
            graphics.put( "Gunderson13", TextureIO.newTexture(ImageIO.read(new File("Images/GundersonFight02.png")), true));
            graphics.put( "Gunderson14", TextureIO.newTexture(ImageIO.read(new File("Images/GundersonFight01.png")), true));

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
            graphics.put( "Toi11", TextureIO.newTexture(ImageIO.read(new File("Images/ToiFight04.png")), true));
            graphics.put( "Toi12", TextureIO.newTexture(ImageIO.read(new File("Images/ToiFight03.png")), true));
            graphics.put( "Toi13", TextureIO.newTexture(ImageIO.read(new File("Images/ToiFight02.png")), true));
            graphics.put( "Toi14", TextureIO.newTexture(ImageIO.read(new File("Images/ToiFight01.png")), true));

            graphics.put( "Hag01", TextureIO.newTexture(ImageIO.read(new File("Images/Hag01.png")), true));
            graphics.put( "Hag02", TextureIO.newTexture(ImageIO.read(new File("Images/Hag02.png")), true));
            graphics.put( "Hag03", TextureIO.newTexture(ImageIO.read(new File("Images/Hag03.png")), true));
            graphics.put( "Hag04", TextureIO.newTexture(ImageIO.read(new File("Images/Hag04.png")), true));
            graphics.put( "Hag05", TextureIO.newTexture(ImageIO.read(new File("Images/Hag05.png")), true));
            graphics.put( "Hag06", TextureIO.newTexture(ImageIO.read(new File("Images/Hag06.png")), true));
            graphics.put( "Hag07", TextureIO.newTexture(ImageIO.read(new File("Images/Hag07.png")), true));
            graphics.put( "Hag08", TextureIO.newTexture(ImageIO.read(new File("Images/Hag08.png")), true));
            graphics.put( "Hag09", TextureIO.newTexture(ImageIO.read(new File("Images/Hag09.png")), true));
            graphics.put( "Hag10", TextureIO.newTexture(ImageIO.read(new File("Images/Hag10.png")), true));

            graphics.put( "BattleArena", TextureIO.newTexture(ImageIO.read(new File("Images/BattleArena.png")), true));


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
