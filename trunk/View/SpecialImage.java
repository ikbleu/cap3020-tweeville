/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

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

/**
 *
 * @author spock
 */
abstract class SpecialImage extends CanIHazImage{
    GraphicsTableSingleton graphics = GraphicsTableSingleton.getInstance();
    OpenGraphicsTable ographics = OpenGraphicsTable.getInstance();

   int wid;
   int hei;

   float widRat;
   float heiRat;


    void drawMe(GL gl, Texture texture, float x, float y){

        Texture current = texture;

        widRat = ((float)(wid))/1280F;
        heiRat = ((float)(hei))/800F;

        current.bind();

        gl.glPushMatrix();

            gl.glBegin(GL.GL_POLYGON);

                gl.glTexCoord2d(0.0, 0.0);
                gl.glVertex2d(x * widRat,y * heiRat);

                gl.glTexCoord2d(0.0, 1.0);
                gl.glVertex2d(x * widRat, (y + ((float)(current.getHeight())/(float)hei)) * heiRat);

                gl.glTexCoord2d(1.0, 1.0);
                gl.glVertex2d((x + ((float)(current.getWidth())/(float)wid)) * widRat, (y + ((float)(current.getHeight())/(float)hei)) * heiRat);

                gl.glTexCoord2d(1.0, 0.0);
                gl.glVertex2d((x + ((float)(current.getWidth())/(float)wid)) * widRat, y * heiRat);


             gl.glEnd();

        gl.glPopMatrix();

    }

    void specdrawMe(GL gl, Texture texture, float x, float y){

        Texture current = texture;

        widRat = ((float)(wid))/1280F;
        heiRat = ((float)(hei))/800F;

        current.bind();

        gl.glPushMatrix();

            gl.glBegin(GL.GL_POLYGON);

                gl.glTexCoord2d(0.0, 0.0);
                gl.glVertex2d(x * widRat + .5,y * heiRat + .5);

                gl.glTexCoord2d(0.0, 1.0);
                gl.glVertex2d(x * widRat + .5, (y + ((float)(current.getHeight())/(float)hei)) * heiRat + .5);

                gl.glTexCoord2d(1.0, 1.0);
                gl.glVertex2d((x + ((float)(current.getWidth())/(float)wid)) * widRat + .5, (y + ((float)(current.getHeight())/(float)hei)) * heiRat + .5);

                gl.glTexCoord2d(1.0, 0.0);
                gl.glVertex2d((x + ((float)(current.getWidth())/(float)wid)) * widRat + .5, y * heiRat + .5);


             gl.glEnd();

        gl.glPopMatrix();

    }

}
