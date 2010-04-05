/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Control.Controller;
import View.View;
import Model.Model;

/**
 *
 * @author spock
 */
public class ControllerTest {
    public static void main(String args[]){
        System.out.println("Hello, I'm am the Controller tester");

        Model model = new Model();
        Controller control = new Controller(model);
        View view = new View(control, model);
        model.register(view);
        model.modeUpdateRegister(view, control);
        control.register(view);
        
    }
}
