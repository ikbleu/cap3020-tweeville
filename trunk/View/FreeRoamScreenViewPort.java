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
import java.util.Collections;
import Model.Character;

/**
 *
 * @author spock
 */
public class FreeRoamScreenViewPort extends SpecialImage{

    private int imageWidth, imageHeight;
    private ViewHelper model;
    GL gl;

    Texture current;

    //LinkedList<Point.Float> unitPoints;
    Point.Float[] unitPoints;

    List<Character> units;


    FreeRoamScreenViewPort( ViewHelper model, GL gl, int wid, int hei )
    {
        this.wid = wid;
        this.hei = hei;
	this.model = model;
	imageWidth = 1130;
	imageHeight = 650;
        this.gl = gl;

        updateEntities();

    }

    void render(){
        drawMe(gl, ographics.getGraphic("colormap"), 0, 0);
        for(int i = 0; i < units.size();++i){
            String h = units.get(i).getCharacter();
            //float g = unitPoints.get(i-1).x;
            
            drawMe(gl, ographics.getGraphic(units.get(i).getCharacter()), (((float)(units.get(i).getLocation().getX()))/((float)wid)), (((float)(units.get(i).getLocation().getY()))/((float)hei)));
        }
    }

    void refreshImage(){

    }

    void updateEntities()
    {
	units = model.getUnits();
        Collections.sort((List)units);
    }
}
