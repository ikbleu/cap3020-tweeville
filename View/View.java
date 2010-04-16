/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Control.GenAdapter;
import Model.ViewHelper;
import Model.Tickable;
import Model.ModeType;
/**
 *
 * @author spock
 */

// used this VM argument to disable DirectDraw for Windows to get
// fullscreen to display properly: -Dsun.java2d.noddraw=true 

public class View implements Tickable{
    ScreenManager screenManager;
    ViewHelper model;


    public View(GenAdapter control, ViewHelper model){
        screenManager = new ScreenManager("hello", control, false, model);
        screenManager.addKeyListener(control);
        screenManager.addMouseListener(control);
        screenManager.addMouseMotionListener(control);
        screenManager.addCKeyListener(control);
        screenManager.addCMouseListener(control);
        screenManager.addCMouseMotionListener(control);
        screenManager.start();
        this.model = model;
    }

    public void onTick(){
        if(screenManager.currentMode == ModeType.BATTLE){
            screenManager.battleScreenViewPort.updateEntities();
        }
        if(screenManager.currentMode == ModeType.FREEROAM || screenManager.currentMode == ModeType.CUTSCENE){
            screenManager.freeRoamScreenViewPort.updateEntities();
        }
    }

    public void startMusic(){
        screenManager.startMusic();
    }

    public void setFRMap(String loc){
        screenManager.freeRoamScreenViewPort.setNewFRImage(loc);
        screenManager.freeRoamScreenViewPort.transitionIn();
    }

    public void setBMap(String loc){
        screenManager.battleScreenViewPort.setNewBImage(loc);
        screenManager.battleScreenViewPort.transitionIn();
    }

    public void setMode(ModeType mode){
        screenManager.setMode(mode);
    }

    public boolean transitionDone(){
        return screenManager.transitionDone();
    }

    public void transitionOut(){
        screenManager.transitionOut();
    }

    public void transitionIn(){
        screenManager.transitionIn();
    }

    public void transitionOutRealOff(){
        screenManager.transitionOutRealOff();
    }

}
