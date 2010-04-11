/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Model.LeashedModel;
import Model.ModeType;
import View.View;
/**
 *
 * @author spock
 */
public class Controller extends GenAdapter {
    private int START_BATTLE_MODE = KeyEvent.VK_B;
    private int START_FR_MODE = KeyEvent.VK_F;
    private int MUSIC = KeyEvent.VK_M;
    private int GAME_EXIT = KeyEvent.VK_F9;
    BattleControl bc;
    BattleMenuControl bmc;
    DialogueControl dc;
    FreeRoamControl frc;
    FreeRoamMenuControl frmc;
    SplashControl sc;
    GenAdapter current = new SplashControl();
    LeashedModel model;
    View view;

    ModeType currentMode = ModeType.SPLASH;

    private int MIN_ENTRY = 30;


    public Controller(LeashedModel model){
        this.model = model;
        bc = new BattleControl(model);
        frc = new FreeRoamControl(model);
        dc = new DialogueControl(model);
    }
    
    public void turnOn(){
        System.out.println("Controller entered");
    }

    public void turnOff(){
        System.out.println("Controller exited");
    }


    public void setMode(ModeType mode){
        currentMode = mode;
        if(mode == ModeType.DIALOGUE){
            current.turnOff();
            dc.turnOn();
            current = dc;
        }
        if(mode == ModeType.FREEROAM){
            current.turnOff();
            frc.turnOn();
            current = frc;
        }
        if(mode == ModeType.BATTLE){
            current.turnOff();
            bc.turnOn();
            current = bc;
        }
    }

    public void register(View view){
        this.view = view;
    }


    boolean canIDoIt( KeyEvent e){
        if(suppression(e)) return true;
        if(e.getKeyCode()==START_BATTLE_MODE && currentMode == ModeType.SPLASH){
            current.turnOff();
            bc.turnOn();
            current = bc;
            currentMode = ModeType.BATTLE;
            view.setMode(ModeType.BATTLE);
            model.setMode(ModeType.BATTLE);
            model.start();
            return true;
        }
        else if(e.getKeyCode()==START_FR_MODE && currentMode == ModeType.SPLASH){
            current.turnOff();
            frc.turnOn();
            model.start();
            current = frc;
            currentMode = ModeType.FREEROAM;
            view.setMode(ModeType.FREEROAM);
            model.setMode(ModeType.FREEROAM);
            model.start();
            return true;
        }
        else if(e.getKeyCode()==MUSIC){
            view.startMusic();
            return true;
        }
        /*else if (){

        }*/
        else if(e.getKeyCode()==GAME_EXIT){
            System.exit(0);
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(!canIDoIt(e)){
            try{
                current.keyPressed(e);
            }
            catch(Exception ex){
                System.out.println("Invalid Key!");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
	current.keyReleased(e);
    }


    @Override
    public void mousePressed(MouseEvent e){

    }

    private KeyEvent prevKey = null;
    private long prevTime = 0;

    private boolean suppression( KeyEvent e ){
        long currtime = System.currentTimeMillis();
        if ( prevKey == null || e.getKeyCode()!=prevKey.getKeyCode() || currtime-prevTime>MIN_ENTRY ){
            prevKey=e;
            prevTime=currtime;
            return false;
        }
        return true;
    }
}
