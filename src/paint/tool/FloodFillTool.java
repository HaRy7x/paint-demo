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
public class FloodFillTool extends Tool {

	BufferedImage currentImage;
	public FloodFillTool(Paint parent) {
		super(parent);
	}

	@Override
	public void actionMouseClicked(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);

		Color color = (SwingUtilities.isLeftMouseButton(evt)) ? parent.color1.getBackground() : parent.color2.getBackground();

		currentImage = canvas.getMainImageCopy();
		Color currcol = new Color(currentImage.getRGB(evt.getX(), evt.getY()));
		floodFill4(currentImage, evt.getX(), evt.getY(), color, currcol);

		canvas.setMainGraphics(currentImage.createGraphics());
		canvas.setMainImage(currentImage);
	}

	@Override
	public void actionMouseDragged(MouseEvent evt, Canvas canvas) {
		super.actionMouseDragged(evt, canvas);
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		super.actionMouseReleased(evt, canvas);

		currentImage.flush();
		System.gc();
	}

	public void floodFill4(BufferedImage image, int x, int y, Color fillColor, Color interiorColor){
		if ((x >= image.getMinX() && y >= image.getMinY()) && (x < image.getWidth() && y < image.getHeight())) {
			Color currcol = new Color(image.getRGB(x, y));
			if (!fillColor.equals(interiorColor) && currcol.equals(interiorColor)){
				image.setRGB(x, y, fillColor.getRGB());
				floodFill4(image, x+1, y, fillColor, interiorColor);
				floodFill4(image, x-1, y, fillColor, interiorColor);
				floodFill4(image, x, y+1, fillColor, interiorColor);
				floodFill4(image, x, y-1, fillColor, interiorColor);
			}
		}
	}
}