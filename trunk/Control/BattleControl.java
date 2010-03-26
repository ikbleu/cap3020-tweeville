/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;

 /*
 * @author spock
 */

class BattleControl extends GenAdapter{
    private boolean active = false;

    BattleControl(){
        active = false;

    }

    void turnOn(){
        active = true;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("You pressed down!");
        }
    }
}
