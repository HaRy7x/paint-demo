/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import paint.shape.LineDDA;
import paint.shape.Shape2D;
import paint.ui.Canvas;
import paint.ui.Paint;

/**
 *
 * @author HaRy7x
 */
public class LineDDATool extends Tool {

	private BufferedImage backupImage;
	private BufferedImage currentImage;
	private Color lineColor;
	private int lineSize;

	public LineDDATool(Paint parent) {
		super(parent);
	}

	@Override
	public void actionMouseClicked(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);

		lineColor = (SwingUtilities.isLeftMouseButton(evt)) ? parent.color1.getBackground() : parent.color2.getBackground();
		lineSize = parent.pixelSlider.getValue();

		backupImage = canvas.getMainImageCopy();
		currentImage = canvas.getMainImageCopy();

		canvas.setMainGraphics(currentImage.createGraphics());
		canvas.setMainImage(currentImage);
	}

	@Override
	public void actionMouseDragged(MouseEvent evt, Canvas canvas) {
		super.actionMouseDragged(evt, canvas);

		canvas.getMainGraphics().drawImage(backupImage, 0, 0, null);

		Shape2D newShape = new LineDDA(startPoint, endPoint, lineSize, lineColor);
		newShape.applyLineStyle(parent.getLineStyle()).draw(currentImage);

		canvas.repaint();
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);

		canvas.setMainImage(currentImage);
		currentImage.flush();
		backupImage.flush();
		System.gc();
	}

}