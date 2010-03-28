/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import javax.swing.JFrame;
import Control.Controller;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.DisplayMode;

/**
 *
 * @author spock
 */
public class ControllerTest {
    public static void main(String args[]){
        System.out.println("Hello, I'm am the Controller tester");
        JFrame blah = new MyFrame("Hello");
        blah.setVisible(true);
        blah.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blah.validate();
        Controller control = new Controller();
        blah.addKeyListener(control);
    }

    private static class MyFrame extends JFrame{
        private boolean fullscreen = true;
        MyFrame(String s){
            super(s);

            GraphicsEnvironment ge = GraphicsEnvironment
                                .getLocalGraphicsEnvironment();
            final GraphicsDevice gs = ge.getDefaultScreenDevice();

            if (fullscreen) {
                this.setUndecorated(true);
                this.setResizable(false);

                DisplayMode dm = gs.getDisplayMode();
                setSize(dm.getWidth(), dm.getHeight());

                if (gs.isFullScreenSupported()) {
                        gs.setFullScreenWindow(this);
                }
            }
        }
    }
}
