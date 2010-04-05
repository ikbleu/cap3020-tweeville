/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Model.ViewHelper;

import java.util.List;
import java.awt.Point;

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

import Model.Viewable;
import java.util.LinkedList;

/**
 *
 * @author spock
 */
public class FreeRoamScreen extends SpecialImage{

    private int imageWidth, imageHeight;
    private ViewHelper model;
    GL gl;

    Texture current;

    LinkedList<Point.Float> unitPoints;

    List<Viewable> units;


    FreeRoamScreen( ViewHelper model, GL gl )
    {
	this.model = model;
	imageWidth = 1130;
	imageHeight = 650;
        this.gl = gl;

        updateEntities();

    }

    void render(){
        for(int i =0; i < units.size();++i){
            drawMe(gl, ographics.getGraphic(units.get(i).getCharacter()), unitPoints.get(i).x, unitPoints.get(i).x);
        }
    }

    void refreshImage(){
        
    }

    void updateEntities()
    {
        System.out.println("I'm getting refreshed, I'm the Free Roam Screen!");
	units = model.getUnits();
        unitPoints = new LinkedList<Point.Float>();

	for(int i = 0; i != units.size(); ++i )
        {
            unitPoints.add( new Point.Float((((float)(units.get(i).getLocation().getX()))/((float)1280)),
                            (((float)(units.get(i).getLocation().getY()))/((float)800))) );
	}
    }
}
