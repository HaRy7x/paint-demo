/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import paint.ui.Canvas;
import paint.ui.Paint;

/**
 *
 * @author HaRy7x
 */
public class ColorPicker extends Tool {

	BufferedImage currentImage;
	Graphics mainGraphic;

	public ColorPicker(Paint parent) {
		super(parent);
	}

	@Override
	public void actionMouseClicked(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);
		currentImage = canvas.getMainImageCopy();
		mainGraphic = currentImage.createGraphics();

		Color color  = new Color(currentImage.getRGB(evt.getX(), evt.getY()));
		if (SwingUtilities.isLeftMouseButton(evt)) {
			parent.color1.setBackground(color);
		} else {
			parent.color2.setBackground(color);
		}
	}

	@Override
	public void actionMouseDragged(MouseEvent evt, Canvas canvas) {
		super.actionMouseDragged(evt, canvas);
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		super.actionMouseReleased(evt, canvas);
		mainGraphic.dispose();
		currentImage.flush();
		System.gc();
	}
	
}