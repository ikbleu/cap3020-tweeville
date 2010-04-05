/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
/**
 *
 * @author spock
 */
public abstract class GenAdapter extends KeyAdapter implements MouseListener, MouseMotionListener{

    public void mouseClicked(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mouseMoved(MouseEvent e){

    }

    public void mouseDragged(MouseEvent e){

    }

    public abstract void turnOff();
    public abstract void turnOn();
}
