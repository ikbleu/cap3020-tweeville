/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author spock
 */
interface GameMap {
    abstract boolean passable(double x, double y, Character c);
}
