/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.tool;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import paint.shape.FilledShape2D;
import paint.shape.LineStyle;
import paint.shape.MaskedLine;
import paint.shape.MidpointEllipse;
import paint.ui.Canvas;
import paint.ui.Paint;

/**
 *
 * @author HaRy7x
 */
public class EllipseTool extends Tool {

	private BufferedImage backupImage;
	private BufferedImage currentImage;
	private String fillType;
	private Color fillColor;
	private Color lineColor;
	private int lineSize;

	public EllipseTool(Paint parent) {
		super(parent);
	}

	@Override
	public void actionMouseClicked(MouseEvent evt, Canvas canvas) {
		super.actionMouseClicked(evt, canvas);

		backupImage = canvas.getMainImageCopy();
		currentImage = canvas.getMainImageCopy();

		if (SwingUtilities.isLeftMouseButton(evt)) {
			fillColor = parent.color2.getBackground();
			lineColor = ("Fill".equals(parent.cmbFillStyle.getSelectedItem())) ? fillColor : parent.color1.getBackground();
		} else {
			fillColor = parent.color1.getBackground();
			lineColor = ("Fill".equals(parent.cmbFillStyle.getSelectedItem())) ? fillColor : parent.color2.getBackground();
		}

		fillType = (String) parent.cmbFillStyle.getSelectedItem();
		lineSize = parent.pixelSlider.getValue();

		canvas.setMainGraphics(currentImage.createGraphics());
		canvas.setMainImage(currentImage);
	}

	@Override
	public void actionMouseDragged(MouseEvent evt, Canvas canvas) {
		super.actionMouseDragged(evt, canvas);

		canvas.getMainGraphics().drawImage(backupImage, 0, 0, null);

		FilledShape2D newShape = new MidpointEllipse(startPoint, endPoint, fillColor, lineSize, lineColor);
		LineStyle style = parent.getLineStyle();
		if (style instanceof MaskedLine) {
			MaskedLine maskedStyle = (MaskedLine)style;
			maskedStyle.setDash((int)(maskedStyle.getDash()*1.5f));
			maskedStyle.setInterDash((int) (maskedStyle.getInterDash()*1.5f));
		}
		newShape.setFillType(fillType);
		newShape.applyLineStyle(style).draw(currentImage);

		canvas.repaint();
	}

	@Override
	public void actionMouseReleased(MouseEvent evt, Canvas canvas) {
		super.actionMouseReleased(evt, canvas);

		canvas.setMainImage(currentImage);
		currentImage.flush();
		backupImage.flush();
		System.gc();
	}
}