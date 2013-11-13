/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author HaRy7x
 */
public abstract class FilledShape2D extends Shape2D {

	protected Color fillColor = Color.WHITE;

	public FilledShape2D(Point startpoint, Point endpoint) {
		super(startpoint, endpoint);
	}

	public FilledShape2D(Point startpoint, Point endpoint, Color fillColor) {
		super(startpoint, endpoint);
		this.fillColor = fillColor;
	}

	public FilledShape2D(Point startpoint, Point endpoint, Color fillColor, int borderSize) {
		super(startpoint, endpoint, borderSize);
		this.fillColor = fillColor;
	}

	public FilledShape2D(Point startpoint, Point endpoint, Color fillColor, int borderSize, Color borderColor) {
		super(startpoint, endpoint, borderSize, borderColor);
		this.fillColor = fillColor;
	}

	public Color getBorderColor() {
		return fillColor;
	}

	public void setBorderColor(Color borderColor) {
		this.fillColor = borderColor;
	}

	public void boundaryFill(BufferedImage image, int x, int y, Color fillColor, Color boundColor){
		if ((x >= image.getMinX() && y >= image.getMinY()) && (x < image.getWidth() && y < image.getHeight())) {
			Color currcol = new Color(image.getRGB(x, y));
			if (!currcol.equals(boundColor) && !currcol.equals(fillColor)){
				image.setRGB(x, y, fillColor.getRGB());
				boundaryFill(image, x+1, y, fillColor, boundColor);
				boundaryFill(image, x-1, y, fillColor, boundColor);
				boundaryFill(image, x, y+1, fillColor, boundColor);
				boundaryFill(image, x, y-1, fillColor, boundColor);
			}
		}
	}

	public abstract boolean intersect(int x, int y);

	public void fillArea(BufferedImage image, int x, int y) {
		fillArea(image, x, y, fillColor);
	}

	public void fillArea(BufferedImage image, int x, int y, Color fillColor) {
		for (int xn = startpoint.x; xn <= endpoint.x; xn++) {
			for (int yn = startpoint.y; yn <= endpoint.y; yn++) {
				if (intersect(xn, yn)) image.setRGB(xn, yn, fillColor.getRGB());
			}
		}
	}

	@Override
	public void draw(BufferedImage image) {
		Graphics g = image.getGraphics();
//		fillArea(image, midpoint.x, midpoint.y);
		draw(g);
		boundaryFill(image, midpoint.x, midpoint.y, fillColor, lineColor);
	}
}