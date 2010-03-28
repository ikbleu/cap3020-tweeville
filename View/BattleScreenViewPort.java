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

class BattleScreenViewPort extends SpecialImage
{
    private int imageWidth, imageHeight;

    BattleScreenViewPort()
    {
	imageWidth = 1130;
	imageHeight = 650;
	imageBuffer = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
    }

    void refreshImage()
    {
	Graphics2D g2d = (Graphics2D) imageBuffer.getGraphics();
	g2d.drawImage( graphics.getGraphic( ViewableEnums.BATTLESCREEN_VIEWPORT ), 0, 0, null );
    }
}
