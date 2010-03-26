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
public class SplashControl extends GenAdapter{
    private boolean active = false;
    String list[] = { "Start", "LoadGame", "Exit" };
    int selector = 0;

    SplashControl(){
        active = false;
    }

    void turnOn(){
        active = true;
    }

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
                System.out.println("Starting game!");
            }

            else if (selector == 1){
                System.out.println("Loading the game!");
            }

            else if (selector == 2){
                System.out.println("Exit!");
                System.exit(0);
            }
        }
    }
}
