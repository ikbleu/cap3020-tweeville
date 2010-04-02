/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Model.LeashedModel;
/**
 *
 * @author spock
 */
public class Controller extends GenAdapter {
    private int START_BATTLE_MODE = KeyEvent.VK_B;
    private int GAME_EXIT = KeyEvent.VK_F9;
    BattleControl bc;
    BattleMenuControl bmc;
    DialogueControl dc;
    FreeRoamControl frc;
    FreeRoamMenuControl frmc;
    SplashControl sc;
    GenAdapter current;
    LeashedModel model;

    private int MIN_ENTRY = 100;


    public Controller(LeashedModel model){
        this.model = model;
        bc = new BattleControl(model);
    }

    boolean canIDoIt( KeyEvent e){
        if(suppression(e)) return true;
        if(e.getKeyCode()==START_BATTLE_MODE){
            bc.turnOn();
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
