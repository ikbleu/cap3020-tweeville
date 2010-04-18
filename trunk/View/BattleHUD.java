/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;

import Model.ViewHelper;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

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

import Model.Viewable;
import java.util.LinkedList;
import java.util.Collections;
import Model.Character;
import Model.UnitStatus;

import Model.ViewHelper;
/**
 *
 * @author spock
 */

// The Elmer Fudd Hud.
class BattleHUD extends SpecialImage
{
    final static int WIDTH = 830;
    final static int HEIGHT = 115;
    Graphics2D g2 = null;
    RenderingHints hint = null;
    Font font;


    int nastHP = 100;
    int gundHP = 100;
    int toitHP = 100;

    GL gl;
    int wid;
    int hei;
    int iwid;
    int ihei;

    int health[] = { 100, 100, 100 };
    int melee[] = { 100, 100, 100 };
    int ranged[] = { 100, 100, 100 };
    Line2D lines[] = new Line2D.Double[9];
    int list[] = { health[0], health[1], health[2], melee[0], melee[1], melee[2],
        ranged[0], ranged[1], ranged[2] };
    Color colors[] = { Color.green, Color.green, Color.green, Color.blue, Color.blue, Color.blue,
        Color.blue, Color.blue, Color.blue };

    private ViewHelper model;

    BattleHUD( ViewHelper model, GL gl, int wid, int hei, int iwid, int ihei )
    {
	this.model = model;
	this.gl = gl;
	this.wid = wid;
	this.hei = hei;
	this.iwid = iwid;
	this.ihei = ihei;

        imageBuffer = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB );
        g2 = imageBuffer.createGraphics();
        hint = new RenderingHints( RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        font = new Font("Levenim MT", Font.PLAIN, 10);
        g2.setFont( font );
        g2.setRenderingHints( hint );
        for( int i = 0; i < lines.length; i++ ){
            lines[i] = new Line2D.Double();
        }
        refreshImage();
    }

    void render( GLAutoDrawable drawable, TextRenderer textRenderer )
    {
		// hud bg
	drawMe( gl, ographics.getGraphic( "BattleHUDBackground" ), 0.1875f, 0.8575f );

    // left HUD section
    // ------------------------------------------------------------------------

	gl.glLineWidth(10.0f);

	// character picture: left section
	drawMe( gl, ographics.getGraphic( "TestHUD" ), 0.203125f, 0.87875f );

	// HP bar capsule: left section
	drawMe( gl, ographics.getGraphic( "BattleHUDBarCapsule" ), 0.2801125f, 0.90875f );

	//

	//charname +=
	// go into model, change accessor to public if needed
	List<Character> characters = model.getUnits();


	for( int i = 0; i < characters.size(); ++i )
	{
	    if( characters.get(i).name.equals( "Nast" ))
	    {
		nastHP = characters.get(i).hp;
	    }
	    else if( characters.get(i).name.equals( "Gunderson" ))
	    {
		gundHP = characters.get(i).hp;
	    }
	    else if( characters.get(i).name.equals( "Toi"))
	    {
		toitHP = characters.get(i).hp;
	    }
	}

	// drawing HP bar: left section
	gl.glColor3f(0.0f, 0.75f, 0.0f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f, 0.91875f); //added .01 to line width
	gl.glVertex2f(0.388906f - (float)((100 - nastHP)*0.00104531f), 0.91875f); //.000104531 increments
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// HP bar capsule overlay: left section
	drawMe( gl, ographics.getGraphic( "BattleBarCapsuleOverlay" ), 0.284375f, 0.911736f );

	// drawing MC bar: left section
	gl.glColor3f(0.0f, 0.75f, 0.0f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f, 0.9425f); //added .01 to line width
	gl.glVertex2f(0.388906f, 0.9425f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// drawing RC bar: left section
	gl.glColor3f(0.0f, 0.75f, 0.0f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f, 0.96625f); //added .01 to line width
	gl.glVertex2f(0.388906f, 0.96625f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// middle hud picture
	drawMe( gl, ographics.getGraphic( "TestHUD" ), 0.40859375f, 0.87875f );

	// drawing HP bar: middle section
	gl.glColor3f(0.75f, 0.0f, 0.0f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f + 0.264f, 0.91875f); //added .01 to line width
	gl.glVertex2f(0.388906f + 0.264f - (float)(((float)(100 - gundHP))*0.00104531f), 0.91875f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// HP bar capsule overlay: middle section
	drawMe( gl, ographics.getGraphic( "BattleBarCapsuleOverlay" ), 0.284375f, 0.911736f );

	// drawing MC bar: middle section
	gl.glColor3f(0.75f, 0.0f, 0.0f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f + 0.264f, 0.9425f); //added .01 to line width
	gl.glVertex2f(0.388906f + 0.264f, 0.9425f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// drawing RC bar: middle section
	gl.glColor3f(0.75f, 0.0f, 0.0f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f + 0.264f, 0.96625f); //added .01 to line width
	gl.glVertex2f(0.388906f + 0.264f, 0.96625f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// far right hud picture
	drawMe( gl, ographics.getGraphic( "TestHUD" ), 0.6140625f, 0.87875f );

	// drawing HP bar: right section
	gl.glColor3f(0.0f, 0.0f, 0.75f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f + 0.224f + 0.284f, 0.91875f); //added .01 to line width
	gl.glVertex2f(0.388906f + 0.244f + 0.284f - (float)((100 - toitHP)*0.00124531f), 0.91875f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// HP bar capsule overlay: right section
	drawMe( gl, ographics.getGraphic( "BattleBarCapsuleOverlay" ), 0.284375f, 0.911736f );

	// drawing MC bar: right section
	gl.glColor3f(0.0f, 0.0f, 0.75f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f + 0.224f + 0.284f, 0.9425f); //added .01 to line width
	gl.glVertex2f(0.388906f + 0.244f + 0.284f, 0.9425f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);

	// drawing RC bar: right section
	gl.glColor3f(0.0f, 0.0f, 0.75f);
	gl.glPushMatrix();
	gl.glBegin(GL.GL_LINES);
	gl.glVertex2f(0.284375f + 0.224f + 0.284f, 0.96625f); //added .01 to line width
	gl.glVertex2f(0.388906f + 0.244f + 0.284f, 0.96625f);
	gl.glEnd();
	gl.glPopMatrix();
	gl.glColor3f(1.0f, 1.0f, 1.0f);
    }

    void refreshImage(){
        g2.setColor( new Color( 0xFFCDAA7D ) );
	g2.fillRect( 0, 0, WIDTH, HEIGHT );

        g2.drawImage( graphics.getGraphic("TestHUD"), (int)(WIDTH/41.5), (int)(HEIGHT/6.76), null );
        g2.drawImage( graphics.getGraphic("TestHUD"), (int)(WIDTH/2.86), (int)(HEIGHT/6.76), null );
        g2.drawImage( graphics.getGraphic("TestHUD"), (int)(WIDTH/1.48), (int)(HEIGHT/6.76), null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.TOITLETYMEHUDFACE), 20, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.NASTIEHUDFACE), 300, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.GUNDERSONHUDFACE), 600, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.TOITLETYMEHUDNAME), 250, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.NASTIEHUDNAME), 450, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.GUNDERSONHUDNAME), 650, 20, null );

        g2.setColor( Color.black );
        g2.drawString( "HP", (int)(WIDTH/7.54), (int)(HEIGHT/2.09) );
        g2.drawString( "HP", (int)(WIDTH/2.18), (int)(HEIGHT/2.09) );
        g2.drawString( "HP", (int)(WIDTH/1.2769), (int)(HEIGHT/2.09) );
        g2.drawString( "MC", (int)(WIDTH/7.54), (int)(HEIGHT/1.53) );
        g2.drawString( "MC", (int)(WIDTH/2.18), (int)(HEIGHT/1.53) );
        g2.drawString( "MC", (int)(WIDTH/1.2769), (int)(HEIGHT/1.53) );
        g2.drawString( "RC", (int)(WIDTH/7.54), (int)(HEIGHT/1.21) );
        g2.drawString( "RC", (int)(WIDTH/2.18), (int)(HEIGHT/1.21) );
        g2.drawString( "RC", (int)(WIDTH/1.2769), (int)(HEIGHT/1.21) );

        g2.setStroke( new BasicStroke( 5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
        lines[0].setLine( (int)(WIDTH/6.14), (int)(HEIGHT/2.3), (int)(WIDTH/6.14) + ((int)(WIDTH/6.38))*health[0]/100, (int)(HEIGHT/2.3) );
        lines[1].setLine( (int)(WIDTH/2.049), (int)(HEIGHT/2.3), (int)(WIDTH/2.049) + ((int)(WIDTH/6.38))*health[1]/100, (int)(HEIGHT/2.3) );
        lines[2].setLine( (int)(WIDTH/1.229), (int)(HEIGHT/2.3), (int)(WIDTH/1.229) + ((int)(WIDTH/6.38))*health[2]/100, (int)(HEIGHT/2.3) );
        lines[3].setLine( (int)(WIDTH/6.14), (int)(HEIGHT/1.64), (int)(WIDTH/6.14) + ((int)(WIDTH/6.38))*melee[0]/100, (int)(HEIGHT/1.64) );
        lines[4].setLine( (int)(WIDTH/2.049), (int)(HEIGHT/1.64), (int)(WIDTH/2.049) + ((int)(WIDTH/6.38))*melee[1]/100, (int)(HEIGHT/1.64) );
        lines[5].setLine( (int)(WIDTH/1.229), (int)(HEIGHT/1.64), (int)(WIDTH/1.229) + ((int)(WIDTH/6.38))*melee[2]/100, (int)(HEIGHT/1.64) );
        lines[6].setLine( (int)(WIDTH/6.14), (int)(HEIGHT/1.27), (int)(WIDTH/6.14) + ((int)(WIDTH/6.38))*ranged[0]/100, (int)(HEIGHT/1.27) );
        lines[7].setLine( (int)(WIDTH/2.049), (int)(HEIGHT/1.27), (int)(WIDTH/2.049) + ((int)(WIDTH/6.38))*ranged[1]/100, (int)(HEIGHT/1.27) );
        lines[8].setLine( (int)(WIDTH/1.229), (int)(HEIGHT/1.27), (int)(WIDTH/1.229) + ((int)(WIDTH/6.38))*ranged[2]/100, (int)(HEIGHT/1.27) );

        for( int i = 0; i < lines.length; i++ ){
            if (list[i] != 0 ){
                if(list[i] < 20)
                    g2.setColor(Color.red);
                else
                    g2.setColor(colors[i]);

                g2.draw(lines[i]);
            }
        }
    }

    void setHP0(int hp){
        health[0] = hp;
        list[0] = hp;
    }

    void setHP1(int hp){
        health[1] = hp;
        list[3] = hp;
    }

    void setHP2(int hp){
        health[2] = hp;
        list[6] = hp;
    }

    void setMC0(int mc){
        melee[0] = mc;
        list[1] = mc;
    }

    void setMC1(int mc){
        melee[1] = mc;
        list[4] = mc;
    }

    void setMC2(int mc){
        melee[2] = mc;
        list[7] = mc;
    }

    void setRC0(int rc){
        ranged[0] = rc;
        list[2] = rc;
    }

    void setRC1(int rc){
        ranged[1] = rc;
        list[5] = rc;
    }

    void setRC2(int rc){
        ranged[2] = rc;
        list[8] = rc;
    }
}
