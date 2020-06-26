package mvc.thermoMVC.view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mvc.thermoMVC.model.Thermometer;
import mvc.thermoMVC.model.ThermometerListener;

public class SwingDisplay extends JPanel implements ThermometerListener {
	
	private JLabel tempLabel;
	
	// The Unicode symbol for degrees
	private static final char DEGREE_SYMBOL = '\u00B0';
	
	/** The thermometer whose temperature is being displayed */
	protected Thermometer thermometer;
	
	/**
	 * Creates a digital thermometer
	 * @param t the thermometer whose temperature is displayed
	 */
	public SwingDisplay(Thermometer t) {
		thermometer = t;
		
		// Create the frame
		JFrame frame = new JFrame ("Swing Display");
		Container mainPanel = frame.getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel tempPanel = new JPanel();
		tempLabel = new JLabel(getDisplayString());
		tempLabel.setFont(tempLabel.getFont().deriveFont(20.0f));
		tempPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		tempPanel.add(tempLabel);
		frame.add(tempPanel);
		// Get the views to listen to the model
		
		frame.pack();
		frame.setVisible (true);
	}

	/**
	 * Create the string to display in the thermometer
	 * @return the string to display in the thermometer
	 */
	private String getDisplayString() {
		return "" + ((thermometer.getTemperature() - 32) * 5/9) + DEGREE_SYMBOL + "C"; // Conversion to C
	}
	
	/**
	 * Change the temperature displayed
	 */
	@Override
	public void temperatureChanged() {
		tempLabel.setText(getDisplayString());
	}

}
