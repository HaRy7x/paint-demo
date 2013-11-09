/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import paint.shape.LineBressenham;
import paint.shape.MidpointCircle;
import paint.shape.MidpointEllipse;
import paint.shape.Shape2D;

/**
 *
 * @author HaRy7x
 */
public class Paint extends javax.swing.JFrame {

	private boolean hasBeenSaved;
	private Point startPoint;
	private Point endPoint;
	private List<Shape2D> drawedShapes = new LinkedList<Shape2D>();

	/**
	 * Creates new form Paint
	 */
	public Paint() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT
	 * modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shapeButtonGroup = new javax.swing.ButtonGroup();
        container = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        shapePanel = new javax.swing.JPanel();
        btnLineDDA = new javax.swing.JToggleButton();
        btnBressenham = new javax.swing.JToggleButton();
        btnMidpointCircle = new javax.swing.JToggleButton();
        btnMidpointEllipse = new javax.swing.JToggleButton();
        btnRectangle = new javax.swing.JToggleButton();
        panelColor = new javax.swing.JPanel();
        color2Wrapper = new javax.swing.JPanel();
        panelColor2 = new javax.swing.JPanel();
        lblColor2 = new javax.swing.JLabel();
        color1Wrapper = new javax.swing.JPanel();
        panelColor1 = new javax.swing.JPanel();
        lblColor1 = new javax.swing.JLabel();
        panelPixel = new javax.swing.JPanel();
        pixelSlider = new javax.swing.JSlider();
        canvas = new Paint.Canvas();
        bottomPanel = new javax.swing.JPanel();
        lbCursor = new javax.swing.JLabel();
        lbCursorPosition = new javax.swing.JLabel();
        lbStart = new javax.swing.JLabel();
        lbStartPosition = new javax.swing.JLabel();
        lbEnd = new javax.swing.JLabel();
        lbEndPosition = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenuItem();
        menuOpen = new javax.swing.JMenuItem();
        menuSave = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cemungudh Paint");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(805, 505));
        setResizable(false);

        mainPanel.setPreferredSize(new java.awt.Dimension(800, 450));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));

        sidePanel.setMaximumSize(new java.awt.Dimension(110, 32767));
        sidePanel.setMinimumSize(new java.awt.Dimension(110, 100));

        shapePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Shapes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        shapePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        shapePanel.setFocusable(false);
        shapePanel.setMaximumSize(new java.awt.Dimension(110, 160));
        shapePanel.setMinimumSize(new java.awt.Dimension(110, 160));
        shapePanel.setPreferredSize(new java.awt.Dimension(110, 160));
        shapePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        shapeButtonGroup.add(btnLineDDA);
        btnLineDDA.setText("Line");
        btnLineDDA.setToolTipText("DDA Algorithm");
        btnLineDDA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLineDDA.setFocusPainted(false);
        btnLineDDA.setFocusable(false);
        btnLineDDA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLineDDA.setMaximumSize(new java.awt.Dimension(30, 30));
        btnLineDDA.setMinimumSize(new java.awt.Dimension(30, 30));
        btnLineDDA.setPreferredSize(new java.awt.Dimension(30, 30));
        btnLineDDA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shapePanel.add(btnLineDDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, 30));

        shapeButtonGroup.add(btnBressenham);
        btnBressenham.setText("Line");
        btnBressenham.setToolTipText("Bressenham Algorithm");
        btnBressenham.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBressenham.setFocusPainted(false);
        btnBressenham.setFocusable(false);
        btnBressenham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBressenham.setMaximumSize(new java.awt.Dimension(25, 25));
        btnBressenham.setMinimumSize(new java.awt.Dimension(25, 25));
        btnBressenham.setPreferredSize(new java.awt.Dimension(26, 26));
        btnBressenham.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shapePanel.add(btnBressenham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 30, 30));

        shapeButtonGroup.add(btnMidpointCircle);
        btnMidpointCircle.setText("Circle");
        btnMidpointCircle.setToolTipText("Midpoint Circle Algorithm");
        btnMidpointCircle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMidpointCircle.setFocusPainted(false);
        btnMidpointCircle.setFocusable(false);
        btnMidpointCircle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMidpointCircle.setMaximumSize(new java.awt.Dimension(30, 30));
        btnMidpointCircle.setMinimumSize(new java.awt.Dimension(30, 30));
        btnMidpointCircle.setPreferredSize(new java.awt.Dimension(30, 30));
        btnMidpointCircle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shapePanel.add(btnMidpointCircle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 30, 30));

        shapeButtonGroup.add(btnMidpointEllipse);
        btnMidpointEllipse.setText("Ellipse");
        btnMidpointEllipse.setToolTipText("Midpoint Ellipse Algorithm");
        btnMidpointEllipse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnMidpointEllipse.setFocusPainted(false);
        btnMidpointEllipse.setFocusable(false);
        btnMidpointEllipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMidpointEllipse.setPreferredSize(new java.awt.Dimension(26, 26));
        btnMidpointEllipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shapePanel.add(btnMidpointEllipse, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 30, 30));

        shapeButtonGroup.add(btnRectangle);
        btnRectangle.setText("Rectangle");
        btnRectangle.setToolTipText("Rectangle");
        btnRectangle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRectangle.setFocusPainted(false);
        btnRectangle.setFocusable(false);
        btnRectangle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRectangle.setPreferredSize(new java.awt.Dimension(26, 26));
        btnRectangle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shapePanel.add(btnRectangle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 30, 30));

        panelColor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Color"));

        panelColor2.setBackground(new java.awt.Color(168, 163, 251));
        panelColor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelColor2.setPreferredSize(new java.awt.Dimension(30, 30));
        panelColor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelColor2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelColor2Layout = new javax.swing.GroupLayout(panelColor2);
        panelColor2.setLayout(panelColor2Layout);
        panelColor2Layout.setHorizontalGroup(
            panelColor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        panelColor2Layout.setVerticalGroup(
            panelColor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        lblColor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblColor2.setText("Color 2");
        lblColor2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout color2WrapperLayout = new javax.swing.GroupLayout(color2Wrapper);
        color2Wrapper.setLayout(color2WrapperLayout);
        color2WrapperLayout.setHorizontalGroup(
            color2WrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(color2WrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblColor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        color2WrapperLayout.setVerticalGroup(
            color2WrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(color2WrapperLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelColor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblColor2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        color1Wrapper.setPreferredSize(new java.awt.Dimension(54, 81));

        panelColor1.setBackground(new java.awt.Color(124, 211, 211));
        panelColor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelColor1.setPreferredSize(new java.awt.Dimension(30, 30));
        panelColor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelColor1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelColor1Layout = new javax.swing.GroupLayout(panelColor1);
        panelColor1.setLayout(panelColor1Layout);
        panelColor1Layout.setHorizontalGroup(
            panelColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        panelColor1Layout.setVerticalGroup(
            panelColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        lblColor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblColor1.setText("Color 1");

        javax.swing.GroupLayout color1WrapperLayout = new javax.swing.GroupLayout(color1Wrapper);
        color1Wrapper.setLayout(color1WrapperLayout);
        color1WrapperLayout.setHorizontalGroup(
            color1WrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(color1WrapperLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(panelColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblColor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        color1WrapperLayout.setVerticalGroup(
            color1WrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(color1WrapperLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelColor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblColor1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelColorLayout = new javax.swing.GroupLayout(panelColor);
        panelColor.setLayout(panelColorLayout);
        panelColorLayout.setHorizontalGroup(
            panelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelColorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(color1Wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(color2Wrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelColorLayout.setVerticalGroup(
            panelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(color1Wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addComponent(color2Wrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPixel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Size"));
        panelPixel.setLayout(new javax.swing.BoxLayout(panelPixel, javax.swing.BoxLayout.LINE_AXIS));

        pixelSlider.setMaximum(50);
        pixelSlider.setMinimum(1);
        pixelSlider.setPaintTicks(true);
        pixelSlider.setSnapToTicks(true);
        pixelSlider.setValue(1);
        pixelSlider.setAlignmentX(0.2F);
        pixelSlider.setAlignmentY(0.2F);
        pixelSlider.setFocusable(false);
        panelPixel.add(pixelSlider);

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPixel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(shapePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(shapePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panelPixel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 129, Short.MAX_VALUE))
        );

        mainPanel.add(sidePanel);

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        canvas.setAlignmentX(0.6F);
        canvas.setAlignmentY(0.6F);
        canvas.setMaximumSize(new java.awt.Dimension(689, 32767));
        canvas.setMinimumSize(new java.awt.Dimension(689, 0));
        canvas.setPreferredSize(new java.awt.Dimension(689, 430));
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvasMouseReleased(evt);
            }
        });
        canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                canvasMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvasMouseDragged(evt);
            }
        });
        canvas.setLayout(new javax.swing.BoxLayout(canvas, javax.swing.BoxLayout.LINE_AXIS));
        mainPanel.add(canvas);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bottomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCursor.setText("Cursor : ");
        lbCursor.setMaximumSize(new java.awt.Dimension(45, 16));
        lbCursor.setMinimumSize(new java.awt.Dimension(45, 16));
        lbCursor.setPreferredSize(new java.awt.Dimension(45, 16));

        lbCursorPosition.setText("-");

        lbStart.setText("Start Point :");

        lbStartPosition.setText("-");

        lbEnd.setText("End Point : ");

        lbEndPosition.setText("-");

        jLabel1.setText("Copyright by : Haryanto M.Rizal, Neng Mira Rahayu, Arvina Yulia");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbCursor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbCursorPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbStartPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbEnd)
                .addGap(0, 0, 0)
                .addComponent(lbEndPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCursor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCursorPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStart)
                    .addComponent(lbStartPosition)
                    .addComponent(lbEnd)
                    .addComponent(lbEndPosition)
                    .addComponent(jLabel1)))
        );

        menuFile.setText("File");

        menuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNew.setText("New");
        menuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewActionPerformed(evt);
            }
        });
        menuFile.add(menuNew);

        menuOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpen.setText("Open");
        menuFile.add(menuOpen);

        menuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSave.setText("Save");
        menuFile.add(menuSave);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        menuBar.add(menuFile);

        menuHelp.setText("Help");

        menuAbout.setText("jMenuItem5");
        menuHelp.add(menuAbout);

        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canvasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseMoved
		lbCursorPosition.setText("[" + evt.getX() + "," + evt.getY() + "]");
    }//GEN-LAST:event_canvasMouseMoved

    private void canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMousePressed
		startPoint = new Point(evt.getX(), evt.getY());
		lbStartPosition.setText("[" + evt.getX() + "," + evt.getY() + "]");
    }//GEN-LAST:event_canvasMousePressed

    private void canvasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseReleased
		endPoint = new Point(evt.getX(), evt.getY());
		lbEndPosition.setText("[" + evt.getX() + "," + evt.getY() + "]");

		// Cara 1 - Copy Imaage dari Canvas
		BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		canvas.paint(g);
		
		// Cara 2 - Copy Image dari Canvas
//		BufferedImage image, temp = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
//		Graphics2D g = temp.createGraphics();
//		g.drawImage((BufferedImage) canvas.createImage(canvas.getWidth(), canvas.getHeight()), null, 0, 0);
//		image = temp;
//		canvas.paint(g);

		int rgb = image.getRGB(evt.getX(), evt.getY());
		System.out.println("R=" + String.valueOf((rgb >> 16) & 0xff) + ", G=" + String.valueOf((rgb >> 8) & 0xff) + ", B=" + String.valueOf(rgb & 0xff));

//		Do nothing if no shape button selected
		if (shapeButtonGroup.getSelection() == null) {
			return;
		}

		int lineSize = pixelSlider.getValue();
		Color lineColor = panelColor1.getBackground();
		Color fillColor = panelColor2.getBackground();

		Shape2D newShape = null;

		if (btnBressenham.isSelected()) {
			newShape = new LineBressenham(startPoint, endPoint, lineSize, lineColor);
		} else if (btnLineDDA.isSelected()) {
			newShape = new LineBressenham(startPoint, endPoint, lineSize, lineColor);
		} else if (btnMidpointCircle.isSelected()) {
			newShape = new MidpointCircle(startPoint, endPoint, fillColor, lineSize, lineColor);
		} else if (btnMidpointEllipse.isSelected()) {
			newShape = new MidpointEllipse(startPoint, endPoint, fillColor, lineSize, lineColor);
		} else if (btnRectangle.isSelected()) {
		}

		((Canvas) canvas).addShape(newShape);

//		drawedShapes.add(newShape);
		newShape.draw(canvas.getGraphics());
//		newShape.draw(0, g);

//		canvas.updateUI();
//		canvas.paintComponents(canvas.getGraphics());
//		canvas.repaint();
		hasBeenSaved = false;
    }//GEN-LAST:event_canvasMouseReleased

    private void canvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseDragged
		lbCursorPosition.setText("[" + evt.getX() + "," + evt.getY() + "]");
    }//GEN-LAST:event_canvasMouseDragged

    private void menuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewActionPerformed
		canvas = new Canvas();
//		((Canvas)canvas).init();
    }//GEN-LAST:event_menuNewActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
		dispose();
    }//GEN-LAST:event_menuExitActionPerformed

    private void panelColor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelColor1MouseClicked
		Color color = JColorChooser.showDialog(this, "Choose Color 1", panelColor1.getBackground());
		if (color == null) return;
		panelColor1.setBackground(color);
		panelColor1.setToolTipText("RGB={" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "}");
    }//GEN-LAST:event_panelColor1MouseClicked

    private void panelColor2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelColor2MouseClicked
		Color color = JColorChooser.showDialog(this, "Choose Color 2", panelColor2.getBackground());
		if (color == null) return;
		panelColor2.setBackground(color);
		panelColor2.setToolTipText("RGB={" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "}");
    }//GEN-LAST:event_panelColor2MouseClicked

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Paint().setVisible(true);
			}
		});
	}

	public class Canvas extends JPanel {

		List<Shape2D> drawedShapes = new LinkedList<Shape2D>();

		public Canvas() {
			super();
		}

		public final void init() {
			addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseReleased(java.awt.event.MouseEvent evt) {
					canvasMouseReleased(evt);
//					repaint();
				}

				public void mousePressed(java.awt.event.MouseEvent evt) {
					canvasMousePressed(evt);
//					repaint();
				}
			});
			addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
				public void mouseMoved(java.awt.event.MouseEvent evt) {
					canvasMouseMoved(evt);
//					repaint();
				}

				public void mouseDragged(java.awt.event.MouseEvent evt) {
					canvasMouseDragged(evt);
//					repaint();
				}
			});
		}

		@Override
		protected void paintChildren(Graphics g) {
			System.out.println("Paint Component");
			super.paintComponent(g);
			for (Shape2D shape : drawedShapes) {
				shape.draw(g);
			}
		}

		public void addShape(Shape2D shape) {
			drawedShapes.add(shape);
//			Graphics g = ((BufferedImage)this.createImage(this.getWidth(), this.getHeight())).createGraphics();
//			paintComponent(g);
//			g.dispose();
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JToggleButton btnBressenham;
    private javax.swing.JToggleButton btnLineDDA;
    private javax.swing.JToggleButton btnMidpointCircle;
    private javax.swing.JToggleButton btnMidpointEllipse;
    private javax.swing.JToggleButton btnRectangle;
    private javax.swing.JPanel canvas;
    private javax.swing.JPanel color1Wrapper;
    private javax.swing.JPanel color2Wrapper;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCursor;
    private javax.swing.JLabel lbCursorPosition;
    private javax.swing.JLabel lbEnd;
    private javax.swing.JLabel lbEndPosition;
    private javax.swing.JLabel lbStart;
    private javax.swing.JLabel lbStartPosition;
    private javax.swing.JLabel lblColor1;
    private javax.swing.JLabel lblColor2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuNew;
    private javax.swing.JMenuItem menuOpen;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JPanel panelColor;
    private javax.swing.JPanel panelColor1;
    private javax.swing.JPanel panelColor2;
    private javax.swing.JPanel panelPixel;
    private javax.swing.JSlider pixelSlider;
    private javax.swing.ButtonGroup shapeButtonGroup;
    private javax.swing.JPanel shapePanel;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
