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
import Model.UnitStatus;

/**
 *
 * @author spock
 */
public class FreeRoamScreenViewPort extends SpecialImage{

    private int imageWidth, imageHeight;
    private ViewHelper model;
    GL gl;

    Texture current;

    Point.Float[] unitPoints;

    List<Character> units;
    Character currChar;
    String frImage;


    FreeRoamScreenViewPort( ViewHelper model, GL gl, int wid, int hei, int iwid, int ihei )
    {
        this.wid = wid;
        this.hei = hei;
	this.model = model;
	imageWidth = 1280;
	imageHeight = 800;
        this.gl = gl;

        frImage = "colormap";

        updateEntities();

    }

    void render(){
        //gl.glPushMatrix();
        //gl.glTranslated(.1, 0, 0);

        specdrawMe(gl, ographics.getGraphic("map1"), (float)((0-currChar.getLocation().getX())/(float)wid), (float)((0-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map2"), (float)((1280-currChar.getLocation().getX())/(float)wid), (float)((0-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map3"), (float)((2560-currChar.getLocation().getX())/(float)wid), (float)((0-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map4"), (float)((0-currChar.getLocation().getX())/(float)wid), (float)((800-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map5"), (float)((1280-currChar.getLocation().getX())/(float)wid), (float)((800-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map6"), (float)((2560-currChar.getLocation().getX())/(float)wid), (float)((800-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map7"), (float)((0-currChar.getLocation().getX())/(float)wid), (float)((1600-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map8"), (float)((1280-currChar.getLocation().getX())/(float)wid), (float)((1600-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic("map9"), (float)((2560-currChar.getLocation().getX())/(float)wid), (float)((1600-currChar.getLocation().getY())/(float)hei));
        for(int i = 0; i < units.size();++i){
            String h = units.get(i).getCharacter();
            //float g = unitPoints.get(i-1).x;
            //if(units.get(i)!= currChar){
                //drawMe(gl, ographics.getGraphic(units.get(i).getCharacter()), (((float)(units.get(i).getLocation().getX()))/((float)wid)), (((float)(units.get(i).getLocation().getY()))/((float)hei)));
                specdrawMe(gl, ographics.getGraphic(units.get(i).getCharacter() + sanim.getStatus(units.get(i).getStatus())), (float)((units.get(i).getLocation().getX()-currChar.getLocation().getX())/(float)wid), (float)((units.get(i).getLocation().getY()-currChar.getLocation().getY())/(float)hei));
        }   //}


        //gl.glPopMatrix();
    }

    void setNewFRImage(){
    }

    void refreshImage(){

    }

    void updateEntities()
    {
	units = model.getUnits();
        currChar = model.getCurrChar();
        Collections.sort((List)units);
    }
}
