/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Control.Controller;
import View.View;

/**
 *
 * @author spock
 */
public class ControllerTest {
    public static void main(String args[]){
        System.out.println("Hello, I'm am the Controller tester");
        Controller control = new Controller();
        View view = new View(control);
        
    }
}