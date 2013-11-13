/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.shape;

import java.awt.Color;
import java.awt.Graphics;
import paint.Drawable;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author HaRy7x
 */
public abstract class Shape2D implements Drawable {

	protected Point startpoint;
	protected Point midpoint;
	protected Point endpoint;

	protected int lineSize = 1;
	protected Color lineColor = Color.BLACK;

	protected LineStyle lineStyle = new SolidLine();

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

	public Shape2D(Point startpoint, Point endpoint, Color lineColor) {
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.midpoint = calculateMidpoint(startpoint, endpoint);
		this.lineColor = lineColor;
	}

	public Shape2D(Point startpoint, Point endpoint, int lineSize, Color lineColor) {
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.midpoint = calculateMidpoint(startpoint, endpoint);
		this.lineSize = lineSize;
		this.lineColor = lineColor;
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

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public void setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
	}

	public Shape2D applyLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
		return this;
	}

	protected final Point calculateMidpoint(Point startpoint, Point endpoint) {
		return new Point((startpoint.x + endpoint.x) / 2, (startpoint.y + endpoint.y) / 2);
	}

	@Override
	public void drawPixel(Graphics g, int x, int y) {
		drawPixel(g, x, y, lineSize);
	}

	@Override
	public void drawPixel(Graphics g, int x, int y, int size) {
		drawPixel(g, x, y, size, this.lineColor);
	}

	@Override
	public void drawPixel(Graphics g, int x, int y, int size, Color pixelColor) {
		int offset = size / 2;
		g.setColor(pixelColor);
		g.fillOval(x - offset, y - offset, size, size);
	}

	@Override
	public void draw(BufferedImage image) {
		Graphics g = image.createGraphics(); draw(g);
		g.dispose();
	}
}