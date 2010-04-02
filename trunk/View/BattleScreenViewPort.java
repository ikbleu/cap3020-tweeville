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
import Model.Viewable;

class BattleScreenViewPort extends SpecialImage
{
    private int imageWidth, imageHeight;
    private ViewHelper model;
    Graphics2D g2d;

    BattleScreenViewPort( ViewHelper model )
    {
	this.model = model;
	imageWidth = 1130;
	imageHeight = 650;
	imageBuffer = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
	g2d = (Graphics2D) imageBuffer.getGraphics();
    }

    void refreshImage()
    {
	// drawing the background
	g2d.drawImage( graphics.getGraphic( "BattleScreenViewPort" ), 0, 0, null );

	updateEntities();
    }

    private void updateEntities()
    {
	Viewable[] units = model.getUnits();
	
	for(int i = 0; i != units.length; ++i )
	{
	    g2d.drawImage( checkOutImage(), (int)units[i].getLocation().getX(),
		    (int)units[i].getLocation().getY(), null );
	}
    }

    private BufferedImage checkOutImage()
    {
	
	return graphics.getGraphic( "NastieS" );
    }
}
