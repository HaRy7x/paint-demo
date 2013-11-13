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
public class LineBressenham extends Shape2D {

	public LineBressenham(Point startpoint, Point endpoint) {
		super(startpoint, endpoint);
	}

	public LineBressenham(Point startpoint, Point endpoint, int lineSize) {
		super(startpoint, endpoint, lineSize);
	}

	public LineBressenham(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	public LineBressenham(Point startpoint, Point endpoint, int lineSize, Color color) {
		super(startpoint, endpoint, lineSize, color);
	}

	public void drawLinebressenham(Graphics g, int X0, int Y0, int X1, int Y1) {
		int dy, dx, stepx, stepy, Pk;
		dy = Y1 - Y0;
		dx = X1 - X0;

		if (dy < 0) {
			dy = -dy;
			stepy = -1;
		} else {
			stepy = 1;
		}

		if (dx < 0) {
			dx = -dx;
			stepx = -1;
		} else {
			stepx = 1;
		}

//		dy = 2*dy;
//		dx = 2*dx;

		drawPixel(g, X0, Y0);

		if (dx > dy) {
			Pk = 2 * dy - dx;
			while (X0 != X1) {
				X0 = X0 + stepx;
				if (Pk >= 0) {
					Y0 = Y0 + stepy;
//					Pk = Pk-2*dx;
					Pk = Pk + 2 * dy - 2 * dx;
				} else {
//					Pk = Pk-2*dy;
					Pk = Pk + 2 * dy;
				}
				drawPixel(g, X0, Y0);
			}
		} else {
			Pk = 2 * dx - dy;
			while (Y0 != Y1) {
				Y0 = Y0 + stepy;
				if (Pk >= 0) {
					X0 = X0 + stepx;
//					Pk = Pk - dy;
					Pk = Pk + 2 * dx - 2 * dy;
				} else {
//					Pk = Pk + dx;
					Pk = Pk + 2 * dx;
				}
				drawPixel(g, X0, Y0);
			}
		}
	}

	public void drawLineBressenhamOptimized(Graphics g, int X0, int Y0, int X1, int Y1) {
		int dy, dx, stepx, stepy, Pk;
		dy = Y1 - Y0;
		dx = X1 - X0;

		if (dy < 0) {
			dy = -dy;
			stepy = -1;
		} else {
			stepy = 1;
		}

		if (dx < 0) {
			dx = -dx;
			stepx = -1;
		} else {
			stepx = 1;
		}

//		dy = 2*dy;
//		dx = 2*dx;

		lineStyle.drawPixel(g, X0, Y0, lineSize, lineColor);

		if (dx > dy) {
			Pk = 2*dy - dx;
			while (X0 != X1) {
				X0 = X0 + stepx;
				if (Pk >= 0) {
					Y0 = Y0 + stepy;
//					Pk = Pk-2*dx;
					Pk = Pk + 2*dy - 2*dx;
				} else {
//					Pk = Pk-2*dy;
					Pk = Pk + 2*dy;
				}
				lineStyle.drawPixel(g, X0, Y0, lineSize, lineColor);
			}
		} else {
			Pk = 2*dx - dy;
			while (Y0 != Y1) {
				Y0 = Y0 + stepy;
				if (Pk >= 0) {
					X0 = X0 + stepx;
//					Pk = Pk - dy;
					Pk = Pk + 2*dx - 2*dy;
				} else {
//					Pk = Pk + dx;
					Pk = Pk + 2*dx;
				}
				lineStyle.drawPixel(g, X0, Y0, lineSize, lineColor);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		drawLineBressenhamOptimized(g, startpoint.x, startpoint.y, endpoint.x, endpoint.y);
	}
}