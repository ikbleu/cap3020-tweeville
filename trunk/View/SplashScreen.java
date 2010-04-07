/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

/**
 *
 * @author spock
 */

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import Model.ViewHelper;
import Model.Viewable;
import java.util.List;
import Model.Character;

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

public class SplashScreen extends SpecialImage
{

    final static private float BSViewPortXOffset = 0.05859375f;
    final static private float BSViewPortYOffset = 0.0975f;

    private int imageWidth, imageHeight;
    private ViewHelper model;
    GL gl;
    List<Character> units;

    Texture current;
    Point.Float nasPoi;

    SplashScreen( ViewHelper model, GL gl, int wid, int hei )
    {
	this.model = model;
	imageWidth = 1130;
	imageHeight = 650;
        this.wid = wid;
        this.hei = hei;
        this.gl = gl;

	//updateEntities();
    }

    void render()
    {
	// drawing the BattleScreen's background (the border around the BattleScreenViewPort's)
	drawMe( gl, ographics.getGraphic( "SplashScreen" ), 0, 0 );
    }

}