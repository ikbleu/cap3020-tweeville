/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;

import Model.LeashedModel;
import Model.DirectionType;


/**
 *
 * @author spock
 */
public class FreeRoamControl extends GenAdapter{
    private boolean active = false;
    LeashedModel model;

    FreeRoamControl(LeashedModel model){
        active = false;
        this.model = model;
    }

    public void turnOn(){
        active = true;
        System.out.println("FreeRoamControl entered");
    }

    public void turnOff(){
        active = false;
        System.out.println("FreeRoamControl exited");
    }

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_W){
            model.moveChar(DirectionType.NORTH);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S){
            model.moveChar(DirectionType.SOUTH);
        }

        else if (e.getKeyCode() == KeyEvent.VK_D){
            model.moveChar(DirectionType.EAST);
        }

        else if (e.getKeyCode() == KeyEvent.VK_A){
            model.moveChar(DirectionType.WEST);
        }

        else if (e.getKeyCode() == KeyEvent.VK_E){
            System.out.println("You pressed the interaction button!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.out.println("You just escaped!");
        }
    }
}
