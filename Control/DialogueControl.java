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
public class DialogueControl extends GenAdapter{
    private boolean active = false;

    DialogueControl(){
        active = false;

    }

    void turnOn(){
        active = true;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("You pressed down!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("You pressed up!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("You pressed enter!");
        }
    }
}
