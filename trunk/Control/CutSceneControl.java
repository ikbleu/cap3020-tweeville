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
public class CutSceneControl extends GenAdapter{
    String[] list = {"", "", "exit"};
    int selector = 0;
    boolean active = false;

    CutSceneControl(){

    }

    public void turnOn(){
        active = true;
        System.out.println("CutScene entered");
    }

    public void turnOff(){
        active = false;
        System.out.println("CutScene exited");
    }

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP){
            
        }

        else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            
        }
    }
}
