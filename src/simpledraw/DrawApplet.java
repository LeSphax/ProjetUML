package simpledraw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * SimpleDraw, applet version
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class DrawApplet
        extends JApplet {

    JToggleButton mySelectButton = new JToggleButton("Select");
    JToggleButton myLineButton = new JToggleButton("Line");
    JToggleButton myCircleButton = new JToggleButton("Circle");
    JButton myGroupButton = new JButton("Group");
    JButton myUngroupButton = new JButton("Ungroup");

    DrawingPanel myDrawingPanel;

    /**
     * Construct the apple
     *
     * @param myDrawing
     */
    public DrawApplet(Drawing myDrawing) {
        myDrawingPanel = new DrawingPanel(myDrawing);
    }

    /**
     * Initialize the applet
     */
    public void init() {
        getContentPane().setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        mySelectButton.setSelected(true);
        mySelectButton.setToolTipText("Select and move shapes");
        myCircleButton.setToolTipText("Draw a Circle");
        myLineButton.setToolTipText("Draw a Line");
        myGroupButton.setToolTipText("Group shapes");
        myUngroupButton.setToolTipText("Ungroup shapes");

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.add(mySelectButton, null);
        buttonPanel.add(myLineButton, null);
        buttonPanel.add(myCircleButton, null);
        buttonPanel.add(myGroupButton, null);
        buttonPanel.add(myUngroupButton, null);
        getContentPane().add(myDrawingPanel, BorderLayout.CENTER);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(mySelectButton);
        buttonGroup.add(myLineButton);
        buttonGroup.add(myCircleButton);
        buttonGroup.add(myGroupButton);
        buttonGroup.add(myUngroupButton);

        setSize(new Dimension(400, 300));

        mySelectButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDrawingPanel.onSelectedClicked(e);
            }
        }
        );

        myLineButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDrawingPanel.onLineClicked(e);
            }
        }
        );

        myCircleButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDrawingPanel.onCircleClicked(e);
            }
        }
        );

        myGroupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myDrawingPanel.onGroupClicked(e);
            }
        });

        myUngroupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myDrawingPanel.onUnGroupClicked(e);
            }
        });
    }
}
