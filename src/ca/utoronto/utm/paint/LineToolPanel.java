package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Makes the Top Panel with 2 buttons and a slider
 * 
 * 
 *
 */
public class LineToolPanel extends JPanel implements ChangeListener, ActionListener {

	static final int FPS_MIN = 1;
	static final int FPS_MAX = 9;
	static final int FPS_INIT = 1;
	private PaintPanel paintPanel;
	private View view;
	private JButton backup;

	public LineToolPanel(View view) {

		JSlider sizeline = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
		this.add(sizeline);
		this.view = view;
		JButton fill = new JButton("Fill");
		JButton outline = new JButton("Outline");
		JButton background = new JButton("Change Background");
		this.add(fill);
		this.add(outline);
		this.add(background);

		backup = outline;
		outline.setEnabled(false);
		sizeline.addChangeListener(this);
		fill.addActionListener(this);
		outline.addActionListener(this);
		background.addActionListener(this);

	}

	/**
	 * Sends information about Slider Value
	 */
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		this.view.getPaintPanel().setThickness(source);
	}

	/**
	 * Send information about action being performed on buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(backup != (JButton)e.getSource())
		{
			backup.setEnabled(true);
			backup = (JButton)e.getSource();
		}
		if(e.getActionCommand() != "Change Background"){
			((JButton)e.getSource()).setEnabled(false);
			}
		this.view.getPaintPanel().setFillStyleSelection(e.getActionCommand());
		if(e.getActionCommand() == "Change Background") {
			this.view.getPaintPanel().setBackground(this.view.getPaintPanel().getColor());
		}
		
	}

}
