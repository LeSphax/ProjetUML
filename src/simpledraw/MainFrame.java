package simpledraw;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    JButton mySaveButton = new JButton("Save");

    DrawingPanel myDrawingPanel;
    Drawing myDrawing;

    /**
     * Construct the frame
     * @param myDrawing
     */
    public MainFrame(Drawing myDrawing) {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            myDrawingPanel = new DrawingPanel(myDrawing);
            this.myDrawing = myDrawing;
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
        mySaveButton.setToolTipText("Save to Json");

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.add(mySelectButton, null);
        buttonPanel.add(myLineButton, null);
        buttonPanel.add(myCircleButton, null);
        buttonPanel.add(myGroupButton, null);
        buttonPanel.add(myUngroupButton, null);
        buttonPanel.add(mySaveButton,null);
        getContentPane().add(myDrawingPanel, BorderLayout.CENTER);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(mySelectButton);
        buttonGroup.add(myLineButton);
        buttonGroup.add(myCircleButton);
        buttonGroup.add(myGroupButton);
        buttonGroup.add(myUngroupButton);
        buttonGroup.add(mySaveButton);
  

        setSize(new Dimension(800,800));
        setTitle("Simple Draw");

        mySelectButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        myDrawingPanel.onSelectedClicked(e);
                    }
                }
        );

        myLineButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        myDrawingPanel.onLineClicked(e);
                    }
                }
        );

        myCircleButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
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
        mySaveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myDrawing.saveJson();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
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
