/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author HaRy7x
 */
public interface Drawable {

	public void drawPixel(Graphics g, int x, int y);
	public void drawPixel(Graphics g, int x, int y, int size);
	public void drawPixel(Graphics g, int x, int y, int size, Color pixelColor);
	public void draw(Graphics g);

}