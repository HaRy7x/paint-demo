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

	public MidpointCircle(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	public MidpointCircle(Point startpoint, Point endpoint, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, color, borderSize, borderColor);
	}

	public void drawPixelOnQuadran(Graphics g, int xc, int yc, int x, int y) {
        drawPixel(g, xc + x, yc + y);
        drawPixel(g, xc - x, yc + y);
        drawPixel(g, xc + x, yc - y);
        drawPixel(g, xc - x, yc - y);
        drawPixel(g, xc + y, yc + x);
        drawPixel(g, xc - y, yc + x);
        drawPixel(g, xc + y, yc - x);
        drawPixel(g, xc - y, yc - x);
    }

	public void drawMidpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0, y = r;
        int P = 1 - r;
        while (x < y) {
            drawPixelOnQuadran(g, xc, yc, x, y);
            x += 1;
            if (P < 0) {
                P += 2 * x + 1;
            } else {
                y -= 1;
                P += 2 * (x - y) + 1;
            }
        }
    }

	@Override
	public void draw(Graphics g) {
		drawMidpointCircle(g, midpoint.x, midpoint.y, borderSize);
	}
}