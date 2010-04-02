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
import Model.ViewHelper;

public class BattleScreen extends SpecialImage
{
    private int imageWidth, imageHeight;
    private int hudPosX, hudPosY;
    private int viewPortPosX, viewPortPosY;
    private BattleHUD hud;
    private BattleScreenViewPort viewPort;

    BattleScreen( ViewHelper model )
    {
	imageWidth = 1280;
	imageHeight = 800;
	hudPosX = (int) (0.1875 * imageWidth);
	hudPosY = (int) (0.85625 * imageHeight);
	viewPortPosX = (int) ( 0.05859375 * imageWidth );
	viewPortPosY = (int) ( 0.09375 * imageHeight );
	imageBuffer = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );

	hud = new BattleHUD( model );
	viewPort = new BattleScreenViewPort( model );
    }

    void refreshImage()
    {
	Graphics2D g2d = (Graphics2D) imageBuffer.getGraphics();
	g2d.drawImage( graphics.getGraphic( "BattleScreen" ), 0, 0, null );

	viewPort.refreshImage();
	g2d.drawImage( viewPort.image(), viewPortPosX, viewPortPosY, null );

	hud.refreshImage();
	g2d.drawImage( hud.image(), hudPosX, hudPosY, null );
    }
}
