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
public class MidpointEllipse extends FilledShape2D {

	public MidpointEllipse(Point startpoint, Point endpoint) {
		super(startpoint, endpoint);
	}

	public MidpointEllipse(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	public MidpointEllipse(Point startpoint, Point endpoint, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, color, borderSize, borderColor);
	}

	public void drawPixelOnQuadran(Graphics g, int xc, int yc, int x, int y) {
		drawPixel(g, xc + x, yc + y);
		drawPixel(g, xc - x, yc + y);
		drawPixel(g, xc + x, yc - y);
		drawPixel(g, xc - x, yc - y);
	}

	public void drawMidpointEllipse(Graphics g, int xc, int yc, int rx, int ry) {
		int RxSq = rx * rx;
		int RySq = ry * ry;
		
		int x = 0, y = ry;
		int Px = 0, Py = 2 * RxSq * y;
		drawPixelOnQuadran(g, xc, yc, x, y);

		// Draw Region-I
		double P = RySq - (RxSq * ry) + (0.25 * RxSq);
		while (Px < Py) {
			x = x + 1;
			Px = Px + 2 * RySq;
			if (P < 0) {
				P = P + RySq + Px;
			} else {
				y = y - 1;
				Py = Py - 2 * RxSq;
				P = P + RySq + Px - Py;
			}
			drawPixelOnQuadran(g, xc, yc, x, y);
		}

		// Draw Region-II
		P = RySq * Math.pow((x + 0.5), 2) + RxSq * Math.pow((y - 1), 2) - RxSq * RySq;
		while (y > 0) {
			y = y -1;
			Py = Py - 2 * RxSq;
			if (P > 0) {
				P = P + RxSq - Py;
			} else {
				x = x + 1;
				Px = Px + 2 * RySq;
				P = P + RxSq - Py + Px;
			}
			drawPixelOnQuadran(g, xc, yc, x, y);
		}
	}

	@Override
	public void draw(Graphics g) {
		drawMidpointEllipse(g, midpoint.x, midpoint.y, borderSize, borderSize);
	}
}
