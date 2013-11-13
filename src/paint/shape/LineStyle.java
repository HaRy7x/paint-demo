/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author HaRy7x
 */
public interface LineStyle {

	public void drawPixel(Graphics g, int x, int y, int size, Color pixelColor);

}