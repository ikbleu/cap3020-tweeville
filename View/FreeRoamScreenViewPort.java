/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

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

    boolean dialogueBoxBegin = true;
    boolean dialogueBoxEnd = false;
    List<String> dialogue = null;
    float dialogueBoxIncX = 0.5f;
    float dialogueBoxIncY = 0.495f;
    float dialogueBoxOffsetX = 0.140625f;
    int charAt = 0;
    boolean lineFlag0 = false;
    boolean lineFlag1 = false;
    boolean lineFlag2 = false;
    String mapName;

    boolean transitionIn;
    double traninc;
    boolean transitionOut;
    double traninc2;
    String bufferIn;

    boolean superBlack;

    boolean transitionOutReal;

    FreeRoamScreenViewPort( ViewHelper model, GL gl, int wid, int hei, int iwid, int ihei )
    {
        this.wid = wid;
        this.hei = hei;
	this.model = model;
	imageWidth = 1280;
	imageHeight = 800;
        this.gl = gl;
        transitionOut = false;
        transitionIn = false;
        traninc = 0;
        traninc2 = 50;

        superBlack = false;

        mapName = "library";

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

    void render( GLAutoDrawable drawable, TextRenderer textRenderer, boolean dialogueMode )
    {
        //gl.glPushMatrix();
        //gl.glTranslated(.1, 0, 0);

        specdrawMe(gl, ographics.getGraphic(mapName + "1"), (float)((0-currChar.getLocation().getX())/(float)wid), (float)((0-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "2"), (float)((1280-currChar.getLocation().getX())/(float)wid), (float)((0-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "3"), (float)((2560-currChar.getLocation().getX())/(float)wid), (float)((0-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "4"), (float)((0-currChar.getLocation().getX())/(float)wid), (float)((800-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "5"), (float)((1280-currChar.getLocation().getX())/(float)wid), (float)((800-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "6"), (float)((2560-currChar.getLocation().getX())/(float)wid), (float)((800-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "7"), (float)((0-currChar.getLocation().getX())/(float)wid), (float)((1600-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "8"), (float)((1280-currChar.getLocation().getX())/(float)wid), (float)((1600-currChar.getLocation().getY())/(float)hei));
        specdrawMe(gl, ographics.getGraphic(mapName + "9"), (float)((2560-currChar.getLocation().getX())/(float)wid), (float)((1600-currChar.getLocation().getY())/(float)hei));

	for(int i = 0; units != null && i < units.size();++i)
	{
            String h = units.get(i).getCharacter();

	    specdrawMe(gl, ographics.getGraphic(units.get(i).getCharacter() + sanim.getStatus(units.get(i).getStatus())), (float)((units.get(i).getLocation().getX()-currChar.getLocation().getX())/(float)wid), (float)((units.get(i).getLocation().getY()-currChar.getLocation().getY())/(float)hei));
	    //drawMe(gl, ographics.getGraphic(units.get(i).getCharacter()), (float)((units.get(i).getLocation().getX()-currChar.getLocation().getX())/(float)wid)+ .5F, (float)((units.get(i).getLocation().getY()-currChar.getLocation().getY())/(float)hei)+ .5F);
	}



     

	if( dialogueMode )
	{
	    drawDialogue( drawable, textRenderer );
	}
	else if( dialogueBoxIncX <= 0.5f ) //dialogue box exit
	{
	    dialogue = null;
	    drawMe(gl, ographics.getGraphic("DialogueBox"), dialogueBoxOffsetX, 0, dialogueBoxIncX, dialogueBoxIncY );
	    
	    if( dialogueBoxIncY < 0.495f )
		dialogueBoxIncY += 0.04f;
	    else if( dialogueBoxIncY >= 0.495f && dialogueBoxIncX <= 0.5f )
	    {
		dialogueBoxIncY = 0.495f;
		dialogueBoxIncX += 0.04f;
	    }
	    
	    if( dialogueBoxIncX >= 0.5f && dialogueBoxIncY >= 0.495f )
	    {
		dialogueBoxIncX = 0.5f;
		dialogueBoxIncY = 0.495f;
	    }
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

        if(transitionOut){
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
    
    void setNewFRImage(String loc)
    {
	mapName = loc;
    }

    void drawDialogue( GLAutoDrawable drawable, TextRenderer textRenderer )
    {
	if( dialogue == null )
	{
	    dialogueBoxBegin = true;
	}

	List oldDialogue = dialogue;
	dialogue = model.getDialogue();

	if( oldDialogue != null && !dialogue.get(0).equals( oldDialogue.get(0) ) )
	{
	    lineFlag0 = true;
	    charAt = 0;
	}
	
	int dialogueChoice = model.getDialogueSelection(); //no choices to be selected indicated by -1

	if( dialogueBoxBegin ) //animated dialogue box entrance
	{
	    
	    drawMe(gl, ographics.getGraphic("DialogueBox"), dialogueBoxOffsetX, 0, dialogueBoxIncX, dialogueBoxIncY );

	    if( dialogueBoxIncX > 0.0f )
		dialogueBoxIncX -= 0.04f;
	    else if( dialogueBoxIncX <= 0.0f && dialogueBoxIncY >= 0.0f )
	    {
		dialogueBoxIncX = 0.0f;
		dialogueBoxIncY -= 0.04f;
	    }
	    
	    if( dialogueBoxIncX <= 0.0f && dialogueBoxIncY <= 0.0f )
	    {
		dialogueBoxIncY = 0.0f;
		dialogueBoxBegin = false;
		lineFlag0 = true;
	    }
	}
	else
	{
	    drawMe(gl, ographics.getGraphic("DialogueBox"), dialogueBoxOffsetX, 0);
	    textRenderer.beginRendering(drawable.getWidth(), drawable.getHeight());
	    //textRenderer.setColor(1.0f, 0.2f, 0.2f, 0.8f); //setting the color for dialogue text
	    List<String> tempDialogue = new ArrayList();
	    String tempLine = "";
	    String tempWord = "";
	    int linePos = 0;

	    Scanner scn = new Scanner( dialogue.get(0) );
	    while( scn.hasNext() )
	    {
		tempWord = scn.next();
		
		if( tempLine.length() + tempWord.length() > 62 )
		{
		    ++linePos;
		    tempDialogue.add( tempLine );
		    tempLine = tempWord;
		}
		else if( tempWord != null && tempLine.equals("") )
		    tempLine = tempLine.concat( tempWord );
		else
		    tempLine = tempLine.concat( " " + tempWord);
	    }

	    tempDialogue.add( tempLine );
	    
	    scn.close();

	    boolean charIncBy1 = false;
	    boolean charIncBy2 = false;
	    boolean charIncBy3 = false;
	    if( lineFlag0 )
	    {
		for( int i = 0; i <= charAt; ++i )
		{
		    if( i + 3 < tempDialogue.get(0).length())
		    {
			textRenderer.draw(tempDialogue.get(0).charAt(i) + "", 190 + ( i * 14 ), 715);
			++i;
			textRenderer.draw(tempDialogue.get(0).charAt(i) + "", 190 + ( i * 14 ), 715);
			++i;
			textRenderer.draw(tempDialogue.get(0).charAt(i) + "", 190 + ( i * 14 ), 715);
			charIncBy2 = false;
			charIncBy1 = false;
			charIncBy3 = true;
		    }
		    else if( i + 2 < tempDialogue.get(0).length()  )
		    {
			textRenderer.draw(tempDialogue.get(0).charAt(i) + "", 190 + ( i * 14 ), 715);
			++i;
			textRenderer.draw(tempDialogue.get(0).charAt(i) + "", 190 + ( i * 14 ), 715);
			charIncBy2 = true;
			charIncBy1 = false;
			charIncBy3 = false;
		    }
		    else
		    {
			textRenderer.draw(tempDialogue.get(0).charAt(i) + "", 190 + ( i * 14 ), 715);
			charIncBy2 = false;
			charIncBy1 = true;
			charIncBy3 = false;
		    }
		}
		    // spacing is i * 14 assuming a Monospaced, Plain style Font of size 24

		if( charIncBy3 )
		    charAt += 3;
		else if( charIncBy2 )
		    charAt += 2;
		else if( charIncBy1 )
		    ++charAt;

		if(charAt >= tempDialogue.get(0).length())
		{
		    lineFlag0 = false;
		    lineFlag1 = true;
		    charAt = 0;
		}
	    }
	    else if( linePos >= 1 && lineFlag1 )
	    {
		textRenderer.draw(tempDialogue.get(0), 190, 715);

		for( int i = 0; i <= charAt; ++i )
		{
		    if( i + 3 < tempDialogue.get(1).length() )
		    {
			textRenderer.draw(tempDialogue.get(1).charAt(i) + "", 190 + ( i * 14 ), 670);
			++i;
			textRenderer.draw(tempDialogue.get(1).charAt(i) + "", 190 + ( i * 14 ), 670);
			++i;
			textRenderer.draw(tempDialogue.get(1).charAt(i) + "", 190 + ( i * 14 ), 670);
			charIncBy2 = false;
			charIncBy1 = false;
			charIncBy3 = true;
		    }
		    else if( i + 2 < tempDialogue.get(1).length()  )
		    {
			textRenderer.draw(tempDialogue.get(1).charAt(i) + "", 190 + ( i * 14 ), 670);
			++i;
			textRenderer.draw(tempDialogue.get(1).charAt(i) + "", 190 + ( i * 14 ), 670);
			charIncBy2 = true;
			charIncBy1 = false;
			charIncBy3 = false;
		    }
		    else
		    {
			textRenderer.draw(tempDialogue.get(1).charAt(i) + "", 190 + ( i * 14 ), 670);
			charIncBy2 = false;
			charIncBy1 = true;
			charIncBy3 = false;
		    }
		}

		if( charIncBy3 )
		    charAt += 3;
		else if( charIncBy2 )
		    charAt += 2;
		else if( charIncBy1 )
		    ++charAt;

		if(charAt >= tempDialogue.get(1).length())
		{
		    lineFlag1 = false;
		    lineFlag2 = true;
		    charAt = 0;
		}
	    }
	    else if( linePos >= 2 && lineFlag2 )
	    {
		textRenderer.draw(tempDialogue.get(0), 190, 715);
		textRenderer.draw(tempDialogue.get(1), 190, 670);
		for( int i = 0; i <= charAt; ++i )
		{
		    if( i + 3 < tempDialogue.get(2).length() )
		    {
			textRenderer.draw(tempDialogue.get(2).charAt(i) + "", 190 + ( i * 14 ), 625);
			++i;
			textRenderer.draw(tempDialogue.get(2).charAt(i) + "", 190 + ( i * 14 ), 625);
			++i;
			textRenderer.draw(tempDialogue.get(2).charAt(i) + "", 190 + ( i * 14 ), 625);
			charIncBy2 = false;
			charIncBy1 = false;
			charIncBy3 = true;
		    }
		    else if( i + 2 < tempDialogue.get(2).length()  )
		    {
			textRenderer.draw(tempDialogue.get(2).charAt(i) + "", 190 + ( i * 14 ), 625);
			++i;
			textRenderer.draw(tempDialogue.get(2).charAt(i) + "", 190 + ( i * 14 ), 625);
			charIncBy2 = true;
			charIncBy1 = false;
			charIncBy3 = false;
		    }
		    else
		    {
			textRenderer.draw(tempDialogue.get(2).charAt(i) + "", 190 + ( i * 14 ), 625);
			charIncBy2 = false;
			charIncBy1 = true;
			charIncBy3 = false;
		    }
		}
		
		if( charIncBy3 )
		    charAt += 3;
		else if( charIncBy2 )
		    charAt += 2;
		else if( charIncBy1 )
		    ++charAt;

		if(charAt >= tempDialogue.get(2).length())
		{
		    lineFlag2 = false;
		    charAt = 0;
		}
	    }
	    else
	    {
		textRenderer.draw(tempDialogue.get(0), 190, 715);
		if( linePos >= 1 )
		    textRenderer.draw(tempDialogue.get(1), 190, 670);
		if( linePos >= 2 )
		    textRenderer.draw(tempDialogue.get(2), 190, 625);
	    }

	    textRenderer.endRendering();
	    //textRenderer.setColor(1.0f, 1.0f, 1.0f, 1.0f); //resetting the color for non-text
	}

	//variable that forces the dialogue to appear on either the top or bottom
    }

    void updateEntities()
    {
	units = model.getUnits();
        currChar = model.getCurrChar();
	if( units != null )
        Collections.sort((List)units); //that random exception when trying to talk to npc happens here
    }
}

//speed up text (try 2 letters at a time, handling the case where the string length is odd)
//make it where when the user hits enter, the rest of the text appears (if 2 letters at a
//time is too slow) and then the next enter makes it continue. this also means that
//