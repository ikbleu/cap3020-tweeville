/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;

import Model.LeashedModel;

/**
 *
 * @author spock
 */
public class DialogueControl extends GenAdapter{
    private boolean active = false;
    LeashedModel model;

    DialogueControl(LeashedModel model){
        active = false;
        this.model = model;
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
            model.scroll(1);
            System.out.println("You pressed down!");

        }

        else if (e.getKeyCode() == KeyEvent.VK_UP){
            model.scroll(-1);
            System.out.println("You pressed up!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            model.nextDialogue();
            System.out.println("You pressed enter!");
        }
    }
}
