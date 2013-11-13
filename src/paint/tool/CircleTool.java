/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import paint.shape.MidpointCircle;
import paint.shape.Shape2D;
import paint.ui.Canvas;
import paint.ui.Paint;

/**
 *
 * @author HaRy7x
 */
public class CircleTool extends Tool {
	
	private BufferedImage backupImage;
	private BufferedImage currentImage;

	public CircleTool(Paint parent) {
		super(parent);
	}

	@Override
	public void actionMouseClicked(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);

		backupImage = canvas.getMainImageCopy();
		currentImage = canvas.getMainImageCopy();

		canvas.setMainGraphics(currentImage.createGraphics());
		canvas.setMainImage(currentImage);
	}

	@Override
	public void actionMouseDragged(MouseEvent evt, Canvas canvas) {
		super.actionMouseDragged(evt, canvas);

		Color fillColor = parent.color2.getBackground();
		Color lineColor = parent.color1.getBackground();
		int lineSize = parent.pixelSlider.getValue();

		canvas.getMainGraphics().drawImage(backupImage, 0, 0, null);

		Shape2D newShape = new MidpointCircle(startPoint, endPoint, fillColor, lineSize, lineColor);
		newShape.setLineStyle(parent.getLineStyle());

		BufferedImage image = (BufferedImage) canvas.createImage(canvas.getWidth(), canvas.getHeight());
		Graphics graphics = image.createGraphics();
		canvas.paint(graphics);
		newShape.draw(image);

		canvas.getMainGraphics().drawImage(image, 0, 0, null);

		canvas.repaint();
		graphics.dispose();
		currentImage.flush();
		backupImage.flush();
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		super.actionMouseReleased(evt, canvas);

		canvas.setMainImage(currentImage);
		currentImage.flush();
		backupImage.flush();
	}
}