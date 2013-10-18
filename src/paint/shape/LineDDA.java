/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author HaRy7x
 */
public class LineDDA extends Shape2D {

	public LineDDA(Point startpoint, Point endpoint) {
		super(startpoint, endpoint);
	}

	public LineDDA(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	@Override
	public void draw(Graphics g) {

	}
}