/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import Model.DirectionType;
import java.awt.event.KeyEvent;
import Model.LeashedModel;
import Model.Tickable;

 /*
 * @author spock
 */

class BattleControl extends GenAdapter implements Tickable {
    private boolean active = false;
    LeashedModel model;

    BattleControl(LeashedModel model){
        active = false;
        this.model = model;
	model.chrisWantsToRegister( this );
    }

    public void turnOn(){
        active = true;
        System.out.println("BattleMode entered");
    }

    public void turnOff(){
        active = false;
        System.out.println("BattleMode exited");
    }

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("You pressed up!");
            model.moveChar(DirectionType.NORTH);
        }

        else if (e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("You pressed down!");
            model.moveChar(DirectionType.SOUTH);
        }

        else if (e.getKeyCode() == KeyEvent.VK_D){
            System.out.println("You pressed right!");
            model.moveChar(DirectionType.EAST);
        }

        else if (e.getKeyCode() == KeyEvent.VK_A){
            System.out.println("You pressed left!");
            model.moveChar(DirectionType.WEST);
        }

        else if (e.getKeyCode() == KeyEvent.VK_E){
            System.out.println("You pressed the use melee button!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_Q){
            System.out.println("You pressed the use ranged weapon button!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_X){
            System.out.println("You just cycled to another character with this button!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.out.println("You just escaped!");
        }
    }
    public void onTick()
    {

    }
}
