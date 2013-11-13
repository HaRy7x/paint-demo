/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import paint.shape.LineBressenham;
import paint.shape.Shape2D;
import paint.ui.Canvas;
import paint.ui.Paint;

/**
 *
 * @author HaRy7x
 */
public class LineBressenhamTool extends Tool {

	private BufferedImage backupImage;
	private BufferedImage currentImage;

	public LineBressenhamTool(Paint parent) {
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

		int lineSize = parent.pixelSlider.getValue();
		Color lineColor = parent.color1.getBackground();

		canvas.getMainGraphics().drawImage(backupImage, 0, 0, null);

		Shape2D newShape = new LineBressenham(startPoint, endPoint, lineSize, lineColor);
		newShape.applyLineStyle(parent.getLineStyle()).draw(currentImage);

		canvas.repaint();
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		super.actionMouseReleased(evt, canvas);

		canvas.setMainImage(currentImage);
		currentImage.flush();
		backupImage.flush();
	}

}