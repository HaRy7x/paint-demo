/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import paint.ui.Canvas;
import paint.ui.Paint;

/**
 *
 * @author HaRy7x
 */
public class BrushTool extends Tool {

	BufferedImage currentImage;
	Color color;
	int size;

	public BrushTool(Paint parent) {
		super(parent);
	}

	@Override
	public void actionMouseClicked(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);

		color = (SwingUtilities.isLeftMouseButton(evt)) ? parent.color1.getBackground() : parent.color2.getBackground();
		size = parent.pixelSlider.getValue();
		
		currentImage = canvas.getMainImageCopy();

		canvas.setMainGraphics(currentImage.createGraphics());
		canvas.setMainImage(currentImage);
	}

	@Override
	public void actionMouseDragged(MouseEvent evt, Canvas canvas) {
		super.actionMouseDragged(evt, canvas);
		canvas.getMainGraphics().setColor(color);
		canvas.getMainGraphics().fillOval(evt.getX() - size/2, evt.getY() - size/2, size, size);
		canvas.repaint();
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		actionMouseClicked(evt, canvas);
		canvas.setMainImage(currentImage);
		currentImage.flush();
	}
	
}