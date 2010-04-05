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
public class FreeRoamControl extends GenAdapter{
    private boolean active = false;

    FreeRoamControl(){
        active = false;

    }

    public void turnOn(){
        active = true;
        System.out.println("FreeRoamControl entered");
    }

    public void turnOff(){
        active = false;
        System.out.println("FreeRoamControl exited");
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("You pressed up!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("You pressed down!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_D){
            System.out.println("You pressed right!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_A){
            System.out.println("You pressed left!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_E){
            System.out.println("You pressed the interaction button!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.out.println("You just escaped!");
        }
    }
}
