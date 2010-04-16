/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import java.awt.event.KeyEvent;

import Model.LeashedModel;
import Model.DirectionType;
import Model.Tickable;


/**
 *
 * @author spock
 */
public class FreeRoamControl extends GenAdapter implements Tickable {
    private boolean active = false;
    LeashedModel model;

    //START: TESTING VARIABLES
    static int counter = 0;
    static boolean tester = false;
    int keyRepeat = -1;
    //END: TESTING VARIABLES
    FreeRoamControl(LeashedModel model){
        active = false;
        this.model = model;
	//model.chrisWantsToRegister( this );
    }

    public void turnOn(){
        active = true;
        System.out.println("FreeRoamControl entered");
    }

    public void turnOff(){
        active = false;
        System.out.println("FreeRoamControl exited");
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_W)
	{
	    if( moveKeysPressed < 2 && !anotherDirection[KeyEvent.VK_W] )
	    {
		anotherDirection[KeyEvent.VK_W] = true;
		++moveKeysPressed;
	    }
	}
	else if (e.getKeyCode() == KeyEvent.VK_S)
	{
	    if( moveKeysPressed < 2 && !anotherDirection[KeyEvent.VK_S] )
	    {
		anotherDirection[KeyEvent.VK_S] = true;
		++moveKeysPressed;
	    }
        }
	else if (e.getKeyCode() == KeyEvent.VK_D)
	{
	    if( moveKeysPressed < 2 && !anotherDirection[KeyEvent.VK_D] )
	    {
		anotherDirection[KeyEvent.VK_D] = true;
		++moveKeysPressed;
	    }
        }

	else if (e.getKeyCode() == KeyEvent.VK_A)
	{
	    if( moveKeysPressed < 2 && !anotherDirection[KeyEvent.VK_A] )
	    {
		anotherDirection[KeyEvent.VK_A] = true;
		++moveKeysPressed;
	    }
        }

        else if (e.getKeyCode() == KeyEvent.VK_E){
            model.action();
            System.out.println("You pressed the interaction button!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_X){
            model.swapChar();
            System.out.println("You just cycled to another character with this button!");
        }

        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.out.println("You just escaped!");
        }
    }

    @Override
    public void keyReleased( KeyEvent e )
    {
	if (e.getKeyCode() == KeyEvent.VK_W)
	{
	   if( anotherDirection[KeyEvent.VK_W] )
	   {
		anotherDirection[KeyEvent.VK_W] = false;
		--moveKeysPressed;
	   }
	}
	else if( e.getKeyCode() == KeyEvent.VK_S)
	{
	    if( anotherDirection[KeyEvent.VK_S] )
	    {
		anotherDirection[KeyEvent.VK_S] = false;
		--moveKeysPressed;
	   }
	}
	else if( e.getKeyCode() == KeyEvent.VK_D)
	{
	    if( anotherDirection[KeyEvent.VK_D] )
	    {
		anotherDirection[KeyEvent.VK_D] = false;
		--moveKeysPressed;
	   }
	}
	else if( e.getKeyCode() == KeyEvent.VK_A)
	{
	    if( anotherDirection[KeyEvent.VK_A] )
	    {
		anotherDirection[KeyEvent.VK_A] = false;
		--moveKeysPressed;
	    }
	}
    }

    public void reset(){
        anotherDirection[KeyEvent.VK_W] = false;
        anotherDirection[KeyEvent.VK_A] = false;
        anotherDirection[KeyEvent.VK_S] = false;
        anotherDirection[KeyEvent.VK_D] = false;
        moveKeysPressed = 0;
    }

    public void onTick()
    {
	//System.out.println(moveKeysPressed); //test code
	//movement keys
	if( suppression() )
	{
            if(moveKeysPressed>1){
                model.setDia(true);
            }
            else{
                model.setDia(false);
            }
	    if( anotherDirection[KeyEvent.VK_W] )
	    {
		    model.moveChar(DirectionType.NORTH, moveKeysPressed>1);
	    }
	    if( anotherDirection[KeyEvent.VK_S] )
	    {
		    model.moveChar(DirectionType.SOUTH, moveKeysPressed>1);
	    }
	    if( anotherDirection[KeyEvent.VK_D] )
	    {
		    model.moveChar(DirectionType.EAST, moveKeysPressed>1);
	    }
	    if( anotherDirection[KeyEvent.VK_A] )
	    {
		    model.moveChar(DirectionType.WEST, moveKeysPressed>1);
	    }
	}
    }
    private int MIN_ENTRY = 40;
    long prevTime = 0;
    private KeyEvent prevKey = null;
    boolean[] anotherDirection = new boolean[250];
    int moveKeysPressed = 0; //when moveKeysPressed = 2, no more movement keys will be recorded

    private boolean suppression( )
    {
	long currtime = System.currentTimeMillis();
	if( currtime-prevTime>MIN_ENTRY )
	{
            prevTime=currtime;
            return true;
        }
        return false;
    }

    //I'm too tired now. Last issue: it pauses because it's hitting the repeat
    //delay of the keyboard. The moveKeysPressed cannot ever == 0 unless
    //NO keys are pressed. Otherwise, pressing two keys to go diagonal
    //and then trying to go in a different direction causes moveKeysPressed
    //to == 0, which then causes keyboard repeat delay. I think this is the
    //issue, anyway... I think it seems to happen when going in a 2-key
    //direction, and then trying to switch to another 2-key direction
    //in one swoop?
}
