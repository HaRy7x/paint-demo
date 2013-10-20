/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.shape;

import java.awt.Color;
import java.awt.Graphics;
import paint.Drawable;
import java.awt.Point;

/**
 *
 * @author HaRy7x
 */
public abstract class Shape2D implements Drawable {

	protected Point startpoint;
	protected Point midpoint;
	protected Point endpoint;

	protected int lineSize = 1;
	protected Color color = Color.BLACK;

	public Shape2D(Point startpoint, Point endpoint) {
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.midpoint = calculateMidpoint(startpoint, endpoint);
	}

	public Shape2D(Point startpoint, Point endpoint, int lineSize) {
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.midpoint = calculateMidpoint(startpoint, endpoint);
		this.lineSize = lineSize;
	}

	public Shape2D(Point startpoint, Point endpoint, Color color) {
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.midpoint = calculateMidpoint(startpoint, endpoint);
		this.color = color;
	}

	public Shape2D(Point startpoint, Point endpoint, int lineSize, Color color) {
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.midpoint = calculateMidpoint(startpoint, endpoint);
		this.lineSize = lineSize;
		this.color = color;
	}

	public Point getStartpoint() {
		return startpoint;
	}

	public Point getMidpoint() {
		return midpoint;
	}

	public Point getEndpoint() {
		return endpoint;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	protected final Point calculateMidpoint(Point startpoint, Point endpoint) {
		return new Point((startpoint.x + endpoint.x)/2, (startpoint.y + endpoint.y)/2);
	}

	@Override
	public void drawPixel(Graphics g, int x, int y) {
		drawPixel(g, x, y, lineSize);
	}

	@Override
	public void drawPixel(Graphics g, int x, int y, int size) {
		drawPixel(g, x, y, size, this.color);
	}
	
	@Override
	public void drawPixel(Graphics g, int x, int y, int size, Color pixelColor) {
		Color prevColor = g.getColor();
		/* Applied shape color to the graphics */
		g.setColor(pixelColor);
		g.fillOval(x, y, size, size);
		g.setColor(prevColor);
	}
}