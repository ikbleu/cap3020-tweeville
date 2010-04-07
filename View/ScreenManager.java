

package View;

import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

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
import javax.media.opengl.GLContext;
import javax.media.opengl.GLDrawableFactory;
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
import Control.Controller;
import Control.GenAdapter;
import Model.ViewHelper;
import Model.ModeType;

class ScreenManager extends JFrame{

    private static final long serialVersionUID = 1212121212;

    public ModeType currentMode;

    private double screenRatio = 1.6;

    private Controller controller;

    private double scale;
    private double panX;
    private double panY;

    private GraphicsTableSingleton graphics = GraphicsTableSingleton.getInstance();

    private GLCanvas canvas;

    private static final double scaleFactor = 0.8;

    private FPSAnimator animator;
    
    BattleScreenViewPort battleScreenViewPort;
    BattleHUD battleHUD;

    FreeRoamScreenViewPort freeRoamScreenViewPort;
    FreeRoamHUD freeRoamHUD;

    SplashScreen splashScreen;

    ViewHelper model;

    private Texture riceTest;
    //private Texture battleScreen_tex;

    public static GL gl;
    public static GLContext context;
    GraphicListener listener;
    public int updateNum = 0;

    public int dfWidth = 800;
    public int dfHeight = 1280;

    ScreenManager(String s, GenAdapter control, boolean fs, ViewHelper model){
        super(s);

        control = controller;

        scale = 1.0;
        panX = 0;
        panY = 0;

        currentMode = ModeType.SPLASH;

        this.model = model;


        if(fs){
            GraphicsEnvironment ge = GraphicsEnvironment
                                .getLocalGraphicsEnvironment();
            final GraphicsDevice gs = ge.getDefaultScreenDevice();
            this.setUndecorated(true);
            this.setResizable(false);

            DisplayMode dm = gs.getDisplayMode();
            setSize(dm.getWidth(), dm.getHeight());

            dfWidth = dm.getWidth();
            dfHeight = dm.getHeight();

            if (gs.isFullScreenSupported()) {
                    gs.setFullScreenWindow(this);
            }
        }
        else{
            setSize(1280, 800);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        listener = new GraphicListener();
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);

        getContentPane().add(canvas);

        animator = new FPSAnimator(canvas, 65);

        setVisible(true);
        this.validate();
    }

    void setMode(ModeType mode){
        this.currentMode = mode;
    }

    void start(){
        animator.start();
        this.validate();
    }

    void updateBattleScreen(){
        /*try{
            battleScreen_tex = TextureIO.newTexture(battleScreen.image(),true);
        }
        catch (GLException e) {
            e.printStackTrace();
        }*/
        //listener.updateBattleScreen(battleScreen.image());
        updateNum = 1;
    }

    public void addCKeyListener(KeyListener control){
        getContentPane().getComponents()[0].addKeyListener(control);
    }
    public void addCMouseListener(MouseListener control){
        getContentPane().getComponents()[0].addMouseListener(control);
    }
    public void addCMouseMotionListener(MouseMotionListener control){
        getContentPane().getComponents()[0].addMouseMotionListener(control);
    }

    class GraphicListener implements GLEventListener {

        public void display(GLAutoDrawable drawable) {

            //GLContext context = GLDrawableFactory.getFactory().createExternalGLContext();
            //GL gl = context.getGL();
            GL gl = drawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
            //renderRice(gl);
            //renderBattleScreen(gl);
            if(currentMode == ModeType.BATTLE){
                battleScreenViewPort.render();
            }
            if(currentMode == ModeType.FREEROAM){
                freeRoamScreenViewPort.render();
            }
	    if(currentMode == ModeType.SPLASH) {
		splashScreen.render();
	    }

        }

        void updateBattleScreen(BufferedImage image){
            battleScreenViewPort.updateEntities();
        }

        void updateFreeRoamScreen(BufferedImage image){
            battleScreenViewPort.updateEntities();
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
                GL gl = drawable.getGL();
                //context = GLDrawableFactory.getFactory().createExternalGLContext();
                //gl = context.getGL();
                //context.makeCurrent();
                //get GL pipeline
                gl.glEnable(GL.GL_TEXTURE_2D);								//enable 2D textures
                gl.glEnable(GL.GL_BLEND);
                gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

                //drawable.getContext().makeCurrent();

                battleScreenViewPort = new BattleScreenViewPort(model, gl, dfWidth, dfHeight);

                freeRoamScreenViewPort = new FreeRoamScreenViewPort(model, gl, dfWidth, dfHeight);

		splashScreen = new SplashScreen( model, gl, dfWidth, dfHeight );
		
                try{
                }
                catch(Exception c){
		    System.out.print("Oh Noes!");

                    System.out.println("sm texture fail!");

                }
            }
            catch (GLException e) {
                e.printStackTrace();
	    }
        }
    }
}
