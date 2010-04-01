/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Control.GenAdapter;

/**
 *
 * @author spock
 */

// used this VM argument to disable DirectDraw for windows to get
// fullscreen to display properly: -Dsun.java2d.noddraw=true 

public class View {
    ScreenManager screenManager;


    public View(GenAdapter control){
        screenManager = new ScreenManager("hello", control, false);
        screenManager.addKeyListener(control);
        screenManager.addMouseListener(control);
        screenManager.addMouseMotionListener(control);
        screenManager.addCKeyListener(control);
        screenManager.addCMouseListener(control);
        screenManager.addCMouseMotionListener(control);
        screenManager.start();
    }
    
}
