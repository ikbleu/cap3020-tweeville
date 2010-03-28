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
    private BufferedImage image;

    BattleScreenViewPort()
    {
	imageWidth = 1280;
	imageHeight = 800;
	hudPosX = (int) (0.1875 * imageWidth);
	hudPosY = (int) (0.85625 * imageHeight);
	image = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
    }

    void refreshImage()
    {
	// draw background

	// get info from model

	// draw hud
    }

    BufferedImage getImage()
    {
	return image;
    }
}
