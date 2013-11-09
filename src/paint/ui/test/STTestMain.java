/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.ui.test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class STTestMain extends JFrame {
    STDrawingArea drawingArea = new STDrawingArea();
    public STTestMain()
    {
        //JFrame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Spelling Trainer");
        setResizable(false);
        setVisible(true);


        //Panel of buttons
        JPanel buttonContainer = new JPanel();
        JButton btnPenColor = new JButton("Red Pen");

        buttonContainer.add(btnPenColor);
        //Drawing Area instantiation


        //Adding things to JFrame
        getContentPane().add(drawingArea);
        getContentPane().add(buttonContainer,BorderLayout.PAGE_END);
        pack();


        //button listener
        btnPenColor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                drawingArea.changePenColor(Color.RED);
            }
        });
    }


    public static void main(String args[])
    {
        STTestMain test = new STTestMain();
    }

}