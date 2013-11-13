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
public class MidpointCircle extends FilledShape2D {

	public MidpointCircle(Point startpoint, Point endpoint) {
		super(startpoint, endpoint);
	}

	public MidpointCircle(Point startpoint, Point endpoint, Color color) {
		super(startpoint, endpoint, color);
	}

	public MidpointCircle(Point startpoint, Point endpoint, Color color, int borderSize) {
		super(startpoint, endpoint, color, borderSize);
	}

	public MidpointCircle(Point startpoint, Point endpoint, Color color, int borderSize, Color borderColor) {
		super(startpoint, endpoint, color, borderSize, borderColor);
	}

	@Override
	public void setLineStyle(LineStyle lineStyle) {
		if (lineStyle instanceof MaskedLine) ((MaskedLine) lineStyle).width *= 3;
		super.setLineStyle(lineStyle);
	}

	public void drawPixelOnOktan(Graphics g, int Xc, int Yc, int X, int Y) {
		lineStyle.drawPixel(g, Xc + X, Yc + Y, lineSize, lineColor);
		lineStyle.drawPixel(g, Xc - X, Yc + Y, lineSize, lineColor);
		lineStyle.drawPixel(g, Xc + X, Yc - Y, lineSize, lineColor);
		lineStyle.drawPixel(g, Xc - X, Yc - Y, lineSize, lineColor);
		lineStyle.drawPixel(g, Xc + Y, Yc + X, lineSize, lineColor);
		lineStyle.drawPixel(g, Xc - Y, Yc + X, lineSize, lineColor);
		lineStyle.drawPixel(g, Xc + Y, Yc - X, lineSize, lineColor);
		lineStyle.drawPixel(g, Xc - Y, Yc - X, lineSize, lineColor);
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
	public boolean intersect(int x, int y) {
		return (midpoint.distance(new Point(x, y)) <= (midpoint.distance(endpoint)));
	}

	@Override
	public void fillArea(BufferedImage image, int x, int y, Color fillColor) {
		int S1 = (int) startpoint.distance(midpoint);
		int S2 = (int) endpoint.distance(midpoint);
		int R = (S1 > S2) ? S1 : S2;
		for (int xn = midpoint.x - R; xn <= midpoint.x + R; xn++) {
			for (int yn = midpoint.y - R; yn <= midpoint.y + R; yn++) {
				if (intersect(xn, yn)) image.setRGB(xn, yn, fillColor.getRGB());
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		// jari-jari adalah jarak startpoint ke midpoint
		int R = (int) startpoint.distance(midpoint);

		if (R == 0) drawPixel(g, midpoint.x, midpoint.y);
		else drawMidpointCircle(g, midpoint.x, midpoint.y, R);
	}

	@Override
	public void draw(BufferedImage image) {
		Graphics g = image.getGraphics();
		fillArea(image, midpoint.x, midpoint.y);
		draw(g);
	}
}