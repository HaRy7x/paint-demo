/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.shape;

import java.awt.Color;
import java.awt.Point;

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
}