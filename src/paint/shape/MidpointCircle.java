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
public class MidpointCircle extends FilledShape2D {

	public MidpointCircle(Point startpoint, Point endpoint) {
		super(startpoint, endpoint);
	}

	public MidpointCircle(Point startpoint, Point endpoint, int lineSize) {
		super(startpoint, endpoint, lineSize);
	}

	public MidpointCircle(Point startpoint, Point endpoint, int lineSize, int borderSize, Color borderColor) {
		super(startpoint, endpoint, lineSize, borderSize, borderColor);
	}

	public MidpointCircle(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	public MidpointCircle(Point startpoint, Point endpoint, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, color, borderSize, borderColor);
	}

	public MidpointCircle(Point startpoint, Point endpoint, int lineSize, Color color) {
		super(startpoint, endpoint, lineSize, color);
	}

	public MidpointCircle(Point startpoint, Point endpoint, int lineSize, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, lineSize, color, borderSize, borderColor);
	}

	public void drawPixelOnOktan(Graphics g, int Xc, int Yc, int X, int Y) {
        drawPixel(g, Xc + X, Yc + Y);
        drawPixel(g, Xc - X, Yc + Y);
        drawPixel(g, Xc + X, Yc - Y);
        drawPixel(g, Xc - X, Yc - Y);
        drawPixel(g, Xc + Y, Yc + X);
        drawPixel(g, Xc - Y, Yc + X);
        drawPixel(g, Xc + Y, Yc - X);
        drawPixel(g, Xc - Y, Yc - X);
    }

	public void drawMidpointCircle(Graphics g, int Xc, int Yc, int R) {
        int X = 0, Y = R;
        int P = 1 - R;

		drawPixelOnOktan(g, Xc, Yc, X, Y);
		do {
			X += 1;
            if (P < 0) {
                P += 2 * X + 1;
            } else {
                Y -= 1;
                P += 2 * (X - Y) + 1;
            }
			drawPixelOnOktan(g, Xc, Yc, X, Y);
        } while (X < Y);
    }

	@Override
	public void draw(Graphics g) {
		// jari-jari adalah jarak startpoint ke midpoint
		int R = (int) startpoint.distance(midpoint);

		if (R == 0) drawPixel(g, midpoint.x, midpoint.y);
		else drawMidpointCircle(g, midpoint.x, midpoint.y, R);
	}
}