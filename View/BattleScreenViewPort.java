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
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;
import javax.swing.JFrame;
import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.ImageUtil;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;

import java.awt.Point;

class BattleScreenViewPort extends SpecialImage
{
    private int imageWidth, imageHeight;
    private ViewHelper model;
    Graphics2D g2d;
    GL gl;

    Texture current;

    Point.Float nasPoi;


    BattleScreenViewPort( ViewHelper model, GL gl )
    {
	this.model = model;
	imageWidth = 1130;
	imageHeight = 650;
        this.gl = gl;

        updateEntities();
	//imageBuffer = new BufferedImage( imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB );
	//g2d = (Graphics2D) imageBuffer.getGraphics();

    }


    void render(){

        ographics.getGraphic("BattleScreen").bind();



        gl.glPushMatrix();

            gl.glBegin(GL.GL_POLYGON);

                gl.glTexCoord2d(0.0, 0.0);
                gl.glVertex2d(0.0,0.0);

                gl.glTexCoord2d(0.0, 1.0);
                gl.glVertex2d(0.0, 1.0);

                gl.glTexCoord2d(1.0, 1.0);
                gl.glVertex2d(1.0, 1.0);

                gl.glTexCoord2d(1.0, 0.0);
                gl.glVertex2d(1.0, 0.0);


             gl.glEnd();

        gl.glPopMatrix();

        current = ographics.getGraphic("NastieS");

        current.bind();

        gl.glPushMatrix();

            gl.glBegin(GL.GL_POLYGON);

                gl.glTexCoord2d(0.0, 0.0);
                gl.glVertex2d(nasPoi.x,nasPoi.y);

                gl.glTexCoord2d(0.0, 1.0);
                gl.glVertex2d(nasPoi.x, nasPoi.y + ((float)(current.getHeight())/(float)imageHeight));

                gl.glTexCoord2d(1.0, 1.0);
                gl.glVertex2d(nasPoi.x + ((float)(current.getWidth())/(float)imageWidth), nasPoi.y + ((float)(current.getHeight())/(float)imageHeight));

                gl.glTexCoord2d(1.0, 0.0);
                gl.glVertex2d(nasPoi.x + ((float)(current.getWidth())/(float)imageWidth), nasPoi.y);


             gl.glEnd();

        gl.glPopMatrix();
    }

    void refreshImage()
    {
	// drawing the background
	g2d.drawImage( graphics.getGraphic( "BattleScreenViewPort" ), 0, 0, null );

	updateEntities();
    }

    void updateEntities()
    {
        System.out.println("I'm getting refreshed");
	List<Viewable> units = model.getUnits();
        int a = (int)units.get(0).getLocation().getX();
        int b = (int)units.get(0).getLocation().getY();
        System.out.println("I'm at " + a + " " + b);


	for(int i = 0; i != units.size(); ++i )
        {
            nasPoi = new Point.Float((((float)(units.get(i).getLocation().getX()))/((float)1280)),
                            (((float)(units.get(i).getLocation().getY()))/((float)800)));
	}
    }

    private BufferedImage checkOutImage()
    {
	
	return graphics.getGraphic( "NastieS" );
    }
}
