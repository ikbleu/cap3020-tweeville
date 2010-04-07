/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;


import java.awt.image.BufferedImage;
/**
 *
 * @author spock
 */
abstract class CanIHazImage {

    BufferedImage imageBuffer;

    BufferedImage image(){
        return imageBuffer;
    }

}
