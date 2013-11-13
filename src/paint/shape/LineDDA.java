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

	public LineDDA(Point startpoint, Point endpoint, int lineSize) {
		super(startpoint, endpoint, lineSize);
	}

	public LineDDA(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	public LineDDA(Point startpoint, Point endpoint, int lineSize, Color color) {
		super(startpoint, endpoint, lineSize, color);
	}

	public void drawLineDDA(Graphics g, int X0, int Y0, int Xend, int Yend){
		int	dx=Xend-X0;
		int dy=Yend-Y0;
		int steps;
		int k;
		float xIncrement;
		float yIncrement;
		float X=X0;
		float Y=Y0;
		
		if(Math.abs(dx)>Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		
		xIncrement = (float)dx / (float)steps;
		yIncrement = (float)dy / (float)steps;
		
		lineStyle.drawPixel(g, Math.round(X), Math.round(Y), lineSize, lineColor);
		for (k = 0; k < steps; k++){
			X += xIncrement;
			Y += yIncrement;
			lineStyle.drawPixel(g, Math.round(X), Math.round(Y), lineSize, lineColor);
		}
	}
	@Override
	public void draw(Graphics g) {
		drawLineDDA(g, startpoint.x, startpoint.y, endpoint.x, endpoint.y);
	}
}