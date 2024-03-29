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
import com.sun.opengl.util.j2d.TextRenderer;
import javax.media.opengl.GLAutoDrawable;

import java.util.Collections;

import java.awt.Point;

class BattleScreenViewPort extends SpecialImage
{
    final static private float BSViewPortXOffset = 0.05859375f;
    final static private float BSViewPortYOffset = 0.0975f;

    private int imageWidth, imageHeight;
    private ViewHelper model;
    GL gl;
    List<Character> units;
    Character currChar;

    Texture current;
    Point.Float nasPoi;

    String mapName;

    boolean transitionIn;
    double traninc;
    boolean transitionOut;
    double traninc2;
    String bufferIn;

    boolean superBlack;

    boolean transitionOutReal;

    BattleScreenViewPort( ViewHelper model, GL gl, int wid, int hei )
    {
	this.model = model;
	imageWidth = 1130;
	imageHeight = 650;
        this.wid = wid;
        this.hei = hei;
        this.gl = gl;

        transitionOut = false;
        transitionIn = false;
        traninc = 0;
        traninc2 = 50;

        superBlack = false;

        mapName = "BattleViewPort";

	updateEntities();
    }

    public boolean transitionDone(){
        /*if(!transitionOut){
            transitionOutReal = false;
        }*/
        return !transitionOut;
    }

    public void transitionOutRealOff(){
        transitionOutReal = false;
    }

    public void transitionIn(){
        transitionIn = true;
        superBlack = false;
        traninc2 = 50;
    }

    public void transitionOut(){
        transitionOut = true;
        transitionOutReal = true;
        traninc = 0;
    }


    void setNewBImage(String loc){
        mapName = loc;
    }

	
    void render( GLAutoDrawable drawable, TextRenderer textRenderer )
    {
	// drawing the BattleScreen's background (the border around the BattleScreenViewPort's)
	//drawMe( gl, ographics.getGraphic( "BattleViewPort" ), 0, 0 );

        specdrawMe(gl, ographics.getGraphic(mapName), (float)((0-currChar.getLocation().getX())/(float)wid), (float)((0-currChar.getLocation().getY())/(float)hei));

	// drawing Nastie
	//drawMe( gl, ographics.getGraphic( "NastieS" ), (((float)(units.get(0).getLocation().getX()))/((float)wid)), (((float)(units.get(0).getLocation().getY()))/((float)hei)));

        for(int i = 0; units != null && i < units.size();++i)
	{
            String h = units.get(i).getCharacter();
	    specdrawMe(gl, ographics.getGraphic(units.get(i).getCharacter() + sanim.getStatus(units.get(i).getStatus())), (float)((units.get(i).getLocation().getX()-currChar.getLocation().getX())/(float)wid), (float)((units.get(i).getLocation().getY()-currChar.getLocation().getY())/(float)hei));
	    //drawMe(gl, ographics.getGraphic(units.get(i).getCharacter()), (float)((units.get(i).getLocation().getX()-currChar.getLocation().getX())/(float)wid)+ .5F, (float)((units.get(i).getLocation().getY()-currChar.getLocation().getY())/(float)hei)+ .5F);
	}

        if(superBlack){
            ographics.getGraphic("black").bind();

            gl.glPushMatrix();

                gl.glBegin(GL.GL_POLYGON);

                    gl.glTexCoord2d(0.0, 0.0);
                    gl.glVertex2d(0.0, 0.0);

                    gl.glTexCoord2d(0.0, 1.0);
                    gl.glVertex2d(0.0, 1.0);

                    gl.glTexCoord2d(1.0, 1.0);
                    gl.glVertex2d(1.0, 1.0);

                    gl.glTexCoord2d(1.0, 0.0);
                    gl.glVertex2d(1.0, 0.0);

                 gl.glEnd();

            gl.glPopMatrix();
        }

        if(transitionOutReal){
            gl.glColor4d(/*traninc2/100.0*/1, /*traninc2/100.0*/1, /*traninc2/100.0*/1, traninc/50.0);

            ographics.getGraphic("black").bind();

            gl.glPushMatrix();

                gl.glBegin(GL.GL_POLYGON);

                    gl.glTexCoord2d(0.0, 0.0);
                    gl.glVertex2d(0.0, 0.0);

                    gl.glTexCoord2d(0.0, 1.0);
                    gl.glVertex2d(0.0, 1.0);

                    gl.glTexCoord2d(1.0, 1.0);
                    gl.glVertex2d(1.0, 1.0);

                    gl.glTexCoord2d(1.0, 0.0);
                    gl.glVertex2d(1.0, 0.0);

                 gl.glEnd();

            gl.glPopMatrix();

            if(traninc == 50){
                superBlack = true;
                transitionOut = false;
            }
            traninc+=1;

            gl.glColor3d(1.0, 1.0, 1.0);
        }

        if(transitionIn){
            gl.glColor4d(/*traninc2/100.0*/1, /*traninc2/100.0*/1, /*traninc2/100.0*/1, traninc2/50.0);

            ographics.getGraphic("black").bind();

            gl.glPushMatrix();

                gl.glBegin(GL.GL_POLYGON);

                    gl.glTexCoord2d(0.0, 0.0);
                    gl.glVertex2d(0.0, 0.0);

                    gl.glTexCoord2d(0.0, 1.0);
                    gl.glVertex2d(0.0, 1.0);

                    gl.glTexCoord2d(1.0, 1.0);
                    gl.glVertex2d(1.0, 1.0);

                    gl.glTexCoord2d(1.0, 0.0);
                    gl.glVertex2d(1.0, 0.0);

                 gl.glEnd();

            gl.glPopMatrix();

            if(traninc2 == 0){
                transitionIn = false;
            }
            traninc2-=1;

            gl.glColor3d(1.0, 1.0, 1.0);
        }

    }

    void updateEntities()
    {
	units = model.getUnits();
        currChar = model.getCurrChar();
	if( units != null )
        Collections.sort((List)units); //that random exception when trying to talk to npc happens here
    }

    /*void updateEntities()
    {
        System.out.println("I'm getting refreshed");
	units = model.getUnits();
        int a = (int)units.get(0).getLocation().getX();
        int b = (int)units.get(0).getLocation().getY();
        System.out.println("I'm at " + a + " " + b);

	for(int i = 0; i != units.size(); ++i )
        {
            nasPoi = new Point.Float((((float)(units.get(i).getLocation().getX()))/((float)1280)),
                            (((float)(units.get(i).getLocation().getY()))/((float)800)));
	}
    }*/
}
