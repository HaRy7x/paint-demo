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
public abstract class FilledShape2D extends Shape2D {

	protected int borderSize = 1;
	protected Color borderColor = Color.BLACK;

	public FilledShape2D(Point startpoint, Point endpoint) {
		super(startpoint, endpoint);
		this.color = Color.WHITE;
	}

	public FilledShape2D(Point startpoint, Point endpoint, int lineSize) {
		super(startpoint, endpoint, lineSize);
	}
	
	public FilledShape2D(Point startpoint, Point endpoint, int lineSize, int borderSize, Color borderColor) {
		super(startpoint, endpoint, lineSize);
		this.borderSize = borderSize;
		this.borderColor = borderColor;
	}

	public FilledShape2D(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	public FilledShape2D(Point startpoint, Point endpoint, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, color);
		this.borderSize = borderSize;
		this.borderColor = borderColor;
	}

	public FilledShape2D(Point startpoint, Point endpoint, int lineSize, Color color) {
		super(startpoint, endpoint, lineSize, color);
	}

	public FilledShape2D(Point startpoint, Point endpoint, int lineSize, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, lineSize, color);
		this.borderSize = borderSize;
		this.borderColor = borderColor;
	}

	public int getBorderSize() {
		return borderSize;
	}

	public void setBorderSize(int borderSize) {
		this.borderSize = borderSize;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
}