/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.event.KeyListener;

/**
 *
 * @author spock
 */
public class View {
    ScreenManager screenManager;


    public View(KeyListener control){
        screenManager = new ScreenManager("hello", true);
        screenManager.addKeyListener(control);
        screenManager.start();
    }
    
}
