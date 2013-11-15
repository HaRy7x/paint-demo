/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author HaRy7x
 */
public class MaskedLine implements LineStyle {

	int width;

	int dash;
	int interDash;

	long mask;
	long pixelMask;
	long defaultMask;

	short[] pattern;

	public MaskedLine(int width, int dash, int interDash) {
		this.width = width;
		this.dash = dash;
		this.interDash = interDash;
		init();
	}

	public MaskedLine(short[] pattern) {
		System.arraycopy(pattern, 0, this.pattern, 0, pattern.length);
	}

	public int getDash() {
		return dash;
	}

	public void setDash(int dash) {
		this.dash = dash;
	}

	public int getInterDash() {
		return interDash;
	}

	public void setInterDash(int interDash) {
		this.interDash = interDash;
	}

	public final void init() {
		double powDash = Math.pow(2, dash * width);
		double powInterDash = Math.pow(2, interDash * width);
		double bitsPow = powDash * powInterDash;

		pixelMask = (long) (bitsPow - powInterDash);
		defaultMask = (long) bitsPow - 1;
		mask = (long) bitsPow;
	}

	public boolean doDrawPixel() {
		int shift = dash + interDash - 1;
		boolean retval = ((pixelMask & mask) >> shift != 0x00);
		if ((defaultMask & mask) == 0x00 ) init();
		defaultMask <<= 1;
		pixelMask <<= 1;
		return retval;
	}

	@Override
	public void drawPixel(Graphics g, int x, int y, int size, Color pixelColor) {
		int shift = dash + interDash - 1;
		if ((pixelMask & mask) >> shift != 0x00) {
			int offset = size / 2;
			g.setColor(pixelColor);
			g.fillOval(x - offset, y - offset, size, size);
		}
		if ((defaultMask & mask) == 0x00 ) init();
		defaultMask <<= 1;
		pixelMask <<= 1;
	}
}