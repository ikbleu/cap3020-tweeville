/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package View;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
/**
 *
 * @author spock
 */

// The Elmer Fudd Hud.
class BattleHUD extends SpecialImage {
    int WIDTH = 830;
    int HEIGHT = 115;
    Graphics2D g2 = null;
    RenderingHints hint = null;
    Font font;

    int health[] = { 100, 100, 100 };
    int melee[] = { 100, 100, 100 };
    int ranged[] = { 100, 100, 100 };
    Line2D lines[] = new Line2D.Double[9];
    int list[] = { health[0], health[1], health[2], melee[0], melee[1], melee[2],
        ranged[0], ranged[1], ranged[2] };
    Color colors[] = { Color.green, Color.green, Color.green, Color.blue, Color.blue, Color.blue,
        Color.blue, Color.blue, Color.blue };

    BattleHUD(){
        imageBuffer = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB );
        g2 = imageBuffer.createGraphics();
        hint = new RenderingHints( RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        font = new Font("Levenim MT", Font.PLAIN, 10);
        g2.setFont( font );
        g2.setRenderingHints( hint );
        for( int i = 0; i < lines.length; i++ ){
            lines[i] = new Line2D.Double();
        }
        refreshImage();
    }

    void refreshImage(){
        g2.setColor( new Color( 0xFFCDAA7D ) );
	g2.fillRect( 0, 0, WIDTH, HEIGHT );

        g2.drawImage( graphics.getGraphic(ViewableEnums.TESTHUDFACE), (int)(WIDTH/41.5), (int)(HEIGHT/6.76), null );
        g2.drawImage( graphics.getGraphic(ViewableEnums.TESTHUDFACE), (int)(WIDTH/2.86), (int)(HEIGHT/6.76), null );
        g2.drawImage( graphics.getGraphic(ViewableEnums.TESTHUDFACE), (int)(WIDTH/1.48), (int)(HEIGHT/6.76), null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.TOITLETYMEHUDFACE), 20, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.NASTIEHUDFACE), 300, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.GUNDERSONHUDFACE), 600, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.TOITLETYMEHUDNAME), 250, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.NASTIEHUDNAME), 450, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.GUNDERSONHUDNAME), 650, 20, null );

        g2.setColor( Color.black );
        g2.drawString( "HP", (int)(WIDTH/7.54), (int)(HEIGHT/2.09) );
        g2.drawString( "HP", (int)(WIDTH/2.18), (int)(HEIGHT/2.09) );
        g2.drawString( "HP", (int)(WIDTH/1.2769), (int)(HEIGHT/2.09) );
        g2.drawString( "MC", (int)(WIDTH/7.54), (int)(HEIGHT/1.53) );
        g2.drawString( "MC", (int)(WIDTH/2.18), (int)(HEIGHT/1.53) );
        g2.drawString( "MC", (int)(WIDTH/1.2769), (int)(HEIGHT/1.53) );
        g2.drawString( "RC", (int)(WIDTH/7.54), (int)(HEIGHT/1.21) );
        g2.drawString( "RC", (int)(WIDTH/2.18), (int)(HEIGHT/1.21) );
        g2.drawString( "RC", (int)(WIDTH/1.2769), (int)(HEIGHT/1.21) );

        g2.setStroke( new BasicStroke( 5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
        lines[0].setLine( (int)(WIDTH/6.14), (int)(HEIGHT/2.3), (int)(WIDTH/6.14) + ((int)(WIDTH/6.38))*health[0]/100, (int)(HEIGHT/2.3) );
        lines[1].setLine( (int)(WIDTH/2.049), (int)(HEIGHT/2.3), (int)(WIDTH/2.049) + ((int)(WIDTH/6.38))*health[1]/100, (int)(HEIGHT/2.3) );
        lines[2].setLine( (int)(WIDTH/1.229), (int)(HEIGHT/2.3), (int)(WIDTH/1.229) + ((int)(WIDTH/6.38))*health[2]/100, (int)(HEIGHT/2.3) );
        lines[3].setLine( (int)(WIDTH/6.14), (int)(HEIGHT/1.64), (int)(WIDTH/6.14) + ((int)(WIDTH/6.38))*melee[0]/100, (int)(HEIGHT/1.64) );
        lines[4].setLine( (int)(WIDTH/2.049), (int)(HEIGHT/1.64), (int)(WIDTH/2.049) + ((int)(WIDTH/6.38))*melee[1]/100, (int)(HEIGHT/1.64) );
        lines[5].setLine( (int)(WIDTH/1.229), (int)(HEIGHT/1.64), (int)(WIDTH/1.229) + ((int)(WIDTH/6.38))*melee[2]/100, (int)(HEIGHT/1.64) );
        lines[6].setLine( (int)(WIDTH/6.14), (int)(HEIGHT/1.27), (int)(WIDTH/6.14) + ((int)(WIDTH/6.38))*ranged[0]/100, (int)(HEIGHT/1.27) );
        lines[7].setLine( (int)(WIDTH/2.049), (int)(HEIGHT/1.27), (int)(WIDTH/2.049) + ((int)(WIDTH/6.38))*ranged[1]/100, (int)(HEIGHT/1.27) );
        lines[8].setLine( (int)(WIDTH/1.229), (int)(HEIGHT/1.27), (int)(WIDTH/1.229) + ((int)(WIDTH/6.38))*ranged[2]/100, (int)(HEIGHT/1.27) );

        for( int i = 0; i < lines.length; i++ ){
            if (list[i] != 0 ){
                if(list[i] < 20)
                    g2.setColor(Color.red);
                else
                    g2.setColor(colors[i]);

                g2.draw(lines[i]);
            }
        }
    }

    void setHP0(int hp){
        health[0] = hp;
        list[0] = hp;
    }

    void setHP1(int hp){
        health[1] = hp;
        list[3] = hp;
    }

    void setHP2(int hp){
        health[2] = hp;
        list[6] = hp;
    }

    void setMC0(int mc){
        melee[0] = mc;
        list[1] = mc;
    }

    void setMC1(int mc){
        melee[1] = mc;
        list[4] = mc;
    }

    void setMC2(int mc){
        melee[2] = mc;
        list[7] = mc;
    }

    void setRC0(int rc){
        ranged[0] = rc;
        list[2] = rc;
    }

    void setRC1(int rc){
        ranged[1] = rc;
        list[5] = rc;
    }

    void setRC2(int rc){
        ranged[2] = rc;
        list[8] = rc;
    }
}
