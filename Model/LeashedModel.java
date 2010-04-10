/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author spock
 */
public interface LeashedModel {
    public abstract void moveChar(DirectionType direction);
    public abstract void action();
    public abstract void scroll(int direction);
    public abstract void nextDialogue();
    public abstract void start();
    public abstract void setMode(ModeType mode);
    public abstract void chrisWantsToRegister( Tickable t );
}
