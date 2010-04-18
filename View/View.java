/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Control.GenAdapter;
import Model.ViewHelper;
import Model.Tickable;
import Model.ModeType;

import javax.media.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.media.bean.playerbean.MediaPlayer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.*;
/**
 *
 * @author spock
 */

// used this VM argument to disable DirectDraw for Windows to get
// fullscreen to display properly: -Dsun.java2d.noddraw=true

public class View implements Tickable{
    ScreenManager screenManager;
    ViewHelper model;
    boolean displayMovie = false;
    boolean displayMovie2 = false;
    GenAdapter genAdapter;

	Player p;
	File f;
	MediaPlayer mp;
	Component c;
	JFrame frame = new JFrame();

    public View(GenAdapter control, ViewHelper model){
        screenManager = new ScreenManager("Tweeville", control, false, model);
        screenManager.addKeyListener(control);
        screenManager.addMouseListener(control);
        screenManager.addMouseMotionListener(control);
        screenManager.addCKeyListener(control);
        screenManager.addCMouseListener(control);
        screenManager.addCMouseMotionListener(control);
        screenManager.start();
        this.model = model;
    }

    public void onTick(){
        if(screenManager.currentMode == ModeType.BATTLE){
            screenManager.battleScreenViewPort.updateEntities();
        }
        if(screenManager.currentMode == ModeType.FREEROAM || screenManager.currentMode == ModeType.CUTSCENE){
            screenManager.freeRoamScreenViewPort.updateEntities();
        }
    }

    public void startMusic(){
        screenManager.startMusic();
    }

    public void setFRMap(String loc){
        screenManager.freeRoamScreenViewPort.setNewFRImage(loc);
        screenManager.freeRoamScreenViewPort.transitionIn();
    }

    public void setBMap(String loc){
        screenManager.battleScreenViewPort.setNewBImage(loc);
        screenManager.battleScreenViewPort.transitionIn();
    }

    public boolean transitionDone(){
        return screenManager.transitionDone();
    }

    public void transitionOut(){
        screenManager.transitionOut();
    }

    public void transitionIn(){
        screenManager.transitionIn();
    }

    public void transitionOutRealOff(){
        screenManager.transitionOutRealOff();
    }

        public void setMode(ModeType mode){
	if( displayMovie )
	{
	    displayMovie = false;

	    long startTime = System.currentTimeMillis();

	    System.out.println("_______________________________"+( System.currentTimeMillis() - startTime));

	    while( ( ( System.currentTimeMillis() - startTime ) / 1000 ) < 210 )
	    {
		if( displayMovie2 ){ displayMovie2 = false;
	    try
	    {System.out.println("LDSKGJKDLSGJLDJDJLGKJKDSJGLDJGLKDSJGLKSDJLKDSGJSLKDGJLDKSGJSLDK");
		playMovie();
	    }
	    catch( Exception e )
	    { }
		}
	    }
	    stopMovie();
	    System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO " + startTime);
	    /*screenManager = new ScreenManager( "hello", genAdapter, false, model);
	            screenManager.addKeyListener(genAdapter);
	 screenManager.addMouseListener(genAdapter);
        screenManager.addMouseMotionListener(genAdapter);
        screenManager.addCKeyListener(genAdapter);
        screenManager.addCMouseListener(genAdapter);
        screenManager.addCMouseMotionListener(genAdapter);
        screenManager.start();
        this.model = model;*/
	}
	screenManager.setMode(mode);
    }

        public void playMovie() throws Exception
	{
	     // START MEDIA PLAYER FUNCTIONALITY



	//Component controls = p.getControlPanelComponent();
	//add( controls, BorderLayout.SOUTH);

    f = new File( "Images/yea.mov" );
    System.out.println("LDSKGSGJL");
    try{
    p = Manager.createRealizedPlayer(f.toURI().toURL());}
    catch( Exception e ) {}
	mp = new MediaPlayer();
	mp.setPlayer( p );
	mp.setBounds(200,0,1024,768);
	c = mp.getVisualComponent();
	frame.setLayout( new BorderLayout() );
	//JPanel panel = new JPanel();
	//panel.setPreferredSize(new Dimension(128, 0));
	//panel.setOpaque(false);
	//Graphics2D g2d = (Graphics2D)panel.getGraphics();
	//g2d.setColor( Color.black );
	//g2d.fillRect(0, 0, 128, 800);
	frame.getContentPane().add(c, BorderLayout.CENTER );
	//frame.getContentPane().add( new BorderPanel(), BorderLayout.LINE_START);

        //frame.getContentPane().add(c);
	frame.setSize( 1280, 800 );
	frame.setName("Tweeville");
	frame.setResizable( false );
	frame.setVisible(true);
	frame.validate();



		mp.start();
		System.out.println("STARTED______________________________________________________kdgsljd");

	//mp.close();

	// END MEDIA PLAYER FUNCTIONALITY
	}
    public void stopMovie()
    {
	//mp.stopAndDeallocate();
	mp.close();
	frame.setVisible(false);
	//this.requestFocusInWindow();
	//listener.display( autoDrawable );
	//this.validate();
	System.out.println("VALIDATED!!!!!!!");

    }

    public void actionMusic(){
        screenManager.startActionSound();
    }



class BorderPanel extends JPanel
{
    BufferedImage blackBorder;
    public BorderPanel()
    {
	try
	{
	    blackBorder = ImageIO.read( new File( "Images\\BlackBorder.png" ) );
	}
	catch( Exception e ){}

	this.setPreferredSize( new Dimension( 128, 0 ) );
	this.setBackground( Color.black );
	this.setVisible(true );
	repaint();
    }

    @Override
    public void paintComponent( Graphics g )
	{
		super.paintComponent( g );

		((Graphics2D) g).drawImage( blackBorder, 0, 0, this );
	}
}

}