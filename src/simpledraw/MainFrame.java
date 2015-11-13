package simpledraw;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Main Frame of SimpleDraw
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class MainFrame
        extends JFrame {

    JToggleButton mySelectButton = new JToggleButton("Select");
    JToggleButton myLineButton = new JToggleButton("Line");
    JToggleButton myCircleButton = new JToggleButton("Circle");
    JButton myGroupButton = new JButton("Group");
    JButton myUngroupButton = new JButton("Ungroup");

    DrawingPanel myDrawingPanel;

    /**
     * Construct the frame
     * @param myDrawing
     */
    public MainFrame(Drawing myDrawing) {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        myDrawingPanel = new DrawingPanel(myDrawing);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Component initialization
     */
    private void jbInit() throws Exception {
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
        setTitle("Simple Draw");

        mySelectButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        myDrawingPanel.activateSelectionTool();
                    }
                }
        );

        myLineButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        myDrawingPanel.activateLineTool();
                    }
                }
        );

        myCircleButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        myDrawingPanel.activateCircleTool();
                    }
                }
        );
        myGroupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myDrawingPanel.handlerGroupClicked();
            }
        });
        
        myUngroupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myDrawingPanel.handlerUngroupClicked();
            }
        });
    }

    /**
     * Overridden so we can exit when window is closed.
     */
    @Override
    protected final void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }
}
