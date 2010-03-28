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
    BufferedImage image = null;
    Graphics2D g2 = null;
    RenderingHints hint = null;
    Font font;

    int health[] = { 100, 100, 100 };
    int melee[] = { 100, 100, 100 };
    int ranged[] = { 100, 100, 100 };
    Line2D lines[] = new Line2D.Double[9];

    BattleHUD(){
        font = new Font("Levenim MT", Font.PLAIN, 38);
        g2.setFont( font );
        image = new BufferedImage( WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB );
        g2 = image.createGraphics();
        hint = new RenderingHints( RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints( hint );
        refreshImage();
    }

    void refreshImage(){
        g2.setColor( new Color( 0xFFCDAA7D ) );
	g2.fillRect( 0, 0, WIDTH, HEIGHT );

        g2.drawImage( graphics.getGraphic(ViewableEnums.TESTHUDFACE), 20, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.TOITLETYMEHUDFACE), 20, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.NASTIEHUDFACE), 300, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.GUNDERSONHUDFACE), 600, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.TOITLETYMEHUDNAME), 250, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.NASTIEHUDNAME), 450, 20, null );
        //g2.drawImage( graphics.getGraphic(ViewableEnums.GUNDERSONHUDNAME), 650, 20, null );

        g2.setColor( Color.black );
        g2.drawString( "HP:", 220, 100 );
        g2.drawString( "HP:", 420, 100 );
        g2.drawString( "HP:", 620, 100 );
        g2.drawString( "Melee:", 220, 120 );
        g2.drawString( "Melee:", 420, 120 );
        g2.drawString( "Melee:", 620, 120 );
        g2.drawString( "Ranged:", 220, 140 );
        g2.drawString( "Ranged:", 420, 140 );
        g2.drawString( "Ranged:", 620, 140 );

        g2.setStroke( new BasicStroke( 1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ) );
        lines[0].setLine( 225,100, 225 + health[0], 100 );
        lines[1].setLine( 425,100, 425 + health[1], 100 );
        lines[2].setLine( 625,100, 625 + health[2], 100 );
        lines[3].setLine( 225,120, 225 + melee[0], 120 );
        lines[4].setLine( 425,120, 425 + melee[1], 120 );
        lines[5].setLine( 625,120, 625 + melee[2], 120 );
        lines[6].setLine( 225,140, 225 + ranged[0], 140 );
        lines[7].setLine( 425,140, 425 + ranged[1], 140 );
        lines[8].setLine( 625,140, 625 + ranged[2], 140 );

        g2.setColor( Color.blue );
        for( int i = 0; i < lines.length; i++ ){
            g2.draw(lines[i]);
        }
    }
}
