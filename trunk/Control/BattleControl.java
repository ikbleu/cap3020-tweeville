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
}
