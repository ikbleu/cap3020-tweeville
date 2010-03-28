/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;

/**
 *
 * @author spock
 */
public class Controller extends GenAdapter{
    private int START_BATTLE_MODE = KeyEvent.VK_B;
    private int GAME_EXIT = KeyEvent.VK_F9;
    BattleControl bc;
    BattleMenuControl bmc;
    DialogueControl dc;
    FreeRoamControl frc;
    FreeRoamMenuControl frmc;
    SplashControl sc;
    GenAdapter current;


    public Controller(){
        bc = new BattleControl();
    }

    boolean canIDoIt( KeyEvent e){
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
}
