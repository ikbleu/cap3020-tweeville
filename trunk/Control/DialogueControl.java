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

    public void turnOn(){
        active = true;
        System.out.println("DialogueControl entered");
    }

    public void turnOff(){
        active = false;
        System.out.println("DialogueControl exited");
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
