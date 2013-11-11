/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
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

	public LineDDATool(Paint parent) {
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

		Shape2D newShape = new LineDDA(startPoint, endPoint, lineSize, lineColor);
		newShape.draw(currentImage);

		canvas.repaint();
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);

		canvas.setMainImage(currentImage);

//		BufferedImage image = ((Canvas) canvas).getMainImage();
//		int rgb = image.getRGB(evt.getX(), evt.getY());
//		System.out.println("R=" + String.valueOf((rgb >> 16) & 0xff) + ", G=" + String.valueOf((rgb >> 8) & 0xff) + ", B=" + String.valueOf(rgb & 0xff));

		currentImage.flush();
		backupImage.flush();
	}

}