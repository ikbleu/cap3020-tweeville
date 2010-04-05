/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Model.LeashedModel;
import Model.ModeType;
/**
 *
 * @author spock
 */
public class Controller extends GenAdapter {
    private int START_BATTLE_MODE = KeyEvent.VK_B;
    private int START_FR_MODE = KeyEvent.VK_F;
    private int GAME_EXIT = KeyEvent.VK_F9;
    BattleControl bc;
    BattleMenuControl bmc;
    DialogueControl dc;
    FreeRoamControl frc;
    FreeRoamMenuControl frmc;
    SplashControl sc;
    GenAdapter current;
    LeashedModel model;

    ModeType currentMode;

    private int MIN_ENTRY = 30;


    public Controller(LeashedModel model){
        this.model = model;
        bc = new BattleControl(model);
    }
    
    public void turnOn(){
        System.out.println("Controller entered");
    }

    public void turnOff(){
        System.out.println("Controller exited");
    }


    public void setMode(ModeType mode){
        currentMode = mode;
    }


    boolean canIDoIt( KeyEvent e){
        if(suppression(e)) return true;
        if(e.getKeyCode()==START_BATTLE_MODE){
            bc.turnOn();
            model.start();
            current = bc;
            return true;
        }
        if(e.getKeyCode()==START_FR_MODE){

            model.start();
            current = bc;
            return true;
        }
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
