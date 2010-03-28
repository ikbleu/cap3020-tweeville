/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

/**
 *
 * @author chris
 */

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class BattleScreen extends SpecialImage
{
    private int imageWidth, imageHeight;
    private int hudPosX, hudPosY;
    private BattleHUD hud;

    BattleScreen()
    {
	imageWidth = 1280;
	imageHeight = 800;
	hudPosX = (int) (0.1875 * imageWidth);
	hudPosY = (int) (0.85625 * imageHeight);
	imageBuffer = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );

	hud = new BattleHUD();
    }

    void refreshImage()
    {
	Graphics2D g2d = (Graphics2D) imageBuffer.getGraphics();
	g2d.drawImage( graphics.getGraphic( ViewableEnums.BATTLESCREEN_VIEWPORT ), 0, 0, null );

	hud.refreshImage();
	g2d.drawImage( hud.image(), hudPosX, hudPosY, null );
    }
}
