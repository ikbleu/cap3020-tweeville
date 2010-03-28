

package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.swing.JFrame;
import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.ImageUtil;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;

import java.awt.Point;
import java.util.LinkedList;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.DisplayMode;


class ScreenManager extends JFrame{

    private static final long serialVersionUID = 1212121212;
    private LinkedList<Point> selectedTiles = new LinkedList<Point>();

    private double screenRatio = 1.6;

    private double scale;
    private double panX;
    private double panY;

    private GraphicsTableSingleton graphics = GraphicsTableSingleton.getInstance();

    private GLCanvas canvas;

    private static final double scaleFactor = 0.8;

    private FPSAnimator animator;

    private BattleHUD battleHUD;

    private Texture riceTest;
    private Texture bHUD_tex;

    ScreenManager(String s, boolean fs){
        super(s);

        scale = 1.0;
        panX = 0;
        panY = 0;

        battleHUD = new BattleHUD();
        battleHUD.refreshImage();

        if(fs){
            GraphicsEnvironment ge = GraphicsEnvironment
                                .getLocalGraphicsEnvironment();
            final GraphicsDevice gs = ge.getDefaultScreenDevice();
            this.setUndecorated(true);
            this.setResizable(false);

            DisplayMode dm = gs.getDisplayMode();
            setSize(dm.getWidth(), dm.getHeight());

            if (gs.isFullScreenSupported()) {
                    gs.setFullScreenWindow(this);
            }
        }
        else{
            setSize(1280, 800);
        }

        GraphicListener listener = new GraphicListener();
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);

        getContentPane().add(canvas);

        animator = new FPSAnimator(canvas, 60);

        setVisible(true);
        this.validate();
    }

    void start(){
            animator.start();
    }

    class GraphicListener implements GLEventListener {

        public void display(GLAutoDrawable drawable) {

            GL gl = drawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
            renderRice(gl);
            renderBattleHUD(gl);

        }

        private void renderBattleHUD(GL gl) {

            bHUD_tex.bind();

            gl.glPushMatrix();

            gl.glBegin(GL.GL_POLYGON);

                gl.glTexCoord2d(0.0, 0.0);
                gl.glVertex2d(0.1875,0.85625);

                gl.glTexCoord2d(0.0, 1.0);
                gl.glVertex2d(0.1875, 1.0);

                gl.glTexCoord2d(1.0, 1.0);
                gl.glVertex2d(.8125, 1.0);

                gl.glTexCoord2d(1.0, 0.0);
                gl.glVertex2d(.8125, 0.85625);


             gl.glEnd();

             gl.glPopMatrix();

        }

        private void renderRice(GL gl) {

            riceTest.bind();

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

        }

        public void displayChanged(GLAutoDrawable drawable, boolean arg1, boolean arg2) {
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {

            GL gl = drawable.getGL();
            gl.glViewport(0, 0, w, h);
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glLoadIdentity();
            gl.glOrtho(0.0, 1.0, 1.0, 0.0, -1.0, 1.0);	//specifies rendering box
            gl.glMatrixMode(GL.GL_MODELVIEW);
            gl.glLoadIdentity();
        }

        public void init(GLAutoDrawable drawable) {

            try {
                GL gl = drawable.getGL();									//get GL pipeline
                gl.glEnable(GL.GL_TEXTURE_2D);								//enable 2D textures
                gl.glEnable(GL.GL_BLEND);
                gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

                try{
                    riceTest = TextureIO.newTexture(graphics.getGraphic(ViewableEnums.RICE),true);
                    bHUD_tex = TextureIO.newTexture(battleHUD.image(),true);
                }
                catch(Exception c){
                    System.out.println("sm texture fail!");
                }
            }
            catch (GLException e) {
                e.printStackTrace();
            }
        }
    }
}
