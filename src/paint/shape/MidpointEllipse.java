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

	public MidpointEllipse(Point startpoint, Point endpoint, Color color, int borderSize) {
		super(startpoint, endpoint, color, borderSize);
	}

	public MidpointEllipse(Point startpoint, Point endpoint, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, color, borderSize, borderColor);
	}

	public void drawPixelOnQuadran(Graphics g, int Xc, int Yc, int Rx, int Ry) {
		drawPixel(g, Xc + Rx, Yc + Ry);
		drawPixel(g, Xc - Rx, Yc + Ry);
		drawPixel(g, Xc + Rx, Yc - Ry);
		drawPixel(g, Xc - Rx, Yc - Ry);
	}

	public void drawMidpointEllipse(Graphics g, int Xc, int Yc, int Rx, int Ry) {
		int RxSq = Rx * Rx;
		int RySq = Ry * Ry;
		
		int X = 0, Y = Ry;
		int Px = 0, Py = 2 * RxSq * Y;
		drawPixelOnQuadran(g, Xc, Yc, X, Y);

		// Draw Region-I
		double P = RySq - (RxSq * Ry) + (0.25 * RxSq);
		while (Px < Py) {
			X = X + 1;
			Px = Px + 2 * RySq;
			if (P < 0) {
				P = P + RySq + Px;
			} else {
				Y = Y - 1;
				Py = Py - 2 * RxSq;
				P = P + RySq + Px - Py;
			}
			drawPixelOnQuadran(g, Xc, Yc, X, Y);
		}

		// Draw Region-II
		P = RySq * Math.pow((X + 0.5), 2) + RxSq * Math.pow((Y - 1), 2) - RxSq * RySq;
//		P = RySq * Math.pow((X + 0.5), 2) + RxSq * (Y - 1) - RxSq * RySq;
		while (Y > 0) {
			Y = Y -1;
			Py = Py - 2 * RxSq;
			if (P > 0) {
				P = P + RxSq - Py;
			} else {
				X = X + 1;
				Px = Px + 2 * RySq;
				P = P + RxSq - Py + Px;
			}
			drawPixelOnQuadran(g, Xc, Yc, X, Y);
		}
	}

	@Override
	public void draw(Graphics g) {
		drawMidpointEllipse(g, midpoint.x, midpoint.y, (int)Math.abs(endpoint.x-startpoint.x)/2, (int)Math.abs(endpoint.y-startpoint.y)/2);
	}
}
