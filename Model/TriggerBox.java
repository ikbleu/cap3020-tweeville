/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author spock
 */
class TriggerBox {
    int xMin;
    int xMax;
    int yMin;
    int yMax;

    TriggerBox(int x1, int x2, int y1, int y2){
        xMin = x1;
        xMax = x2;
        yMin = y1;
        yMax = y2;
    }

    boolean inside( int x, int y ){

        if(x >= xMin && x <= xMax && y >= yMin && y <= yMax){
            return true;
        }
        return false;
    }

}
