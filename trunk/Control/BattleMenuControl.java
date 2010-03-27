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
    String[] list = {"", "", "exit"};
    int selector = 0;
    boolean active = false;

    BattleMenuControl(){

    }

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("You pressed down!");
            selector++;
            if (selector == list.length){
                selector = 0;
            }
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("You pressed up!");
            selector--;
            if (selector == -1){
                selector = list.length - 1;
            }
        }

        else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("You pressed enter!");
            if (selector == 0){
                System.out.println("First option");
            }

            else if (selector == 1){
                System.out.println("Second option!");
            }

            else if (selector == 2){
                System.out.println("Exit!");
            }
        }
    }
}
