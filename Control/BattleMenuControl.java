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
public class BattleMenuControl extends GenAdapter{
    String[] commands = {"items", "characters", "exit"};
    int selected = 0;
    boolean active = false;

    BattleMenuControl(){

    }

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            selected++;
            System.out.println("You pressed down!");
        }
    }
}
