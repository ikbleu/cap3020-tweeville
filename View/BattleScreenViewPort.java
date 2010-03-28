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

class BattleScreenViewPort extends SpecialImage
{
    private int imageWidth, imageHeight;
    private int hudPosX, hudPosY;

    BattleScreenViewPort()
    {
	imageWidth = 1280;
	imageHeight = 800;
	imageBuffer = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
    }

    void refreshImage()
    {
	// draw background

	// get info from model

	// draw hud
    }
}
