import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ConvertTemp extends JFrame
{//instance varaiables
	JLabel labelFahr;
	JLabel labelCels;
	JTextField textFahr;
	JTextField textcels;
	JButton conFahToCel;
	JButton conCelToFah;
	
	public ConvertTemp () {
		super("Temperature");
		setLayout (new FlowLayout());
		
		labelFahr=new JLabel ("Fahrenheit: ", SwingConstants.LEFT);
		labelFahr.setToolTipText("This is a temperature scale");
		add(labelFahr);
		textFahr = new JTextField (10);
		add(textFahr);
		
		labelCels = new JLabel("Celsius: ", SwingConstants.LEFT);
		labelCels.setToolTipText("This is a scale and unit of measurement for temperature");
		add(labelCels);
		textcels= new JTextField(10);
		add(textcels);
		
		conFahToCel=new JButton ("Convert Fahrenheit to Celsius");
		add(conFahToCel);
		conCelToFah=new JButton("Convert Celsius to Fahrenheit ");
		add(conCelToFah);
		
		
		JPanel panel = new JPanel(new GridLayout(2,2,12,6));
		panel.add(labelFahr);
		panel.add(labelCels);
		panel.add(textFahr);
		panel.add(textcels);
		add(panel,BorderLayout.NORTH);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(conFahToCel);
		buttonPanel.add(conCelToFah);
		add(buttonPanel,BorderLayout.SOUTH);
		conFahToCel.addActionListener(new FahrListener());
		conCelToFah.addActionListener(new CelsListener());
		
	}//end constructor
	
	private class FahrListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==conFahToCel) {
				int conFahToCel=(int)((5.0/9.0*(((Double.parseDouble(textFahr.getText())) -32))));
				textcels.setText(conFahToCel +"\u2103");
				textFahr.requestFocus();
				textFahr.selectAll();
			} // end if statement
		}//end actionPerformed
	}//end FahrListener
	
	
	private class CelsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()== conCelToFah) {
				int conCelToFah =(int) ((9.0/5.0*(((Double.parseDouble(textcels.getText())) +32))));
				textFahr.setText(conCelToFah + "\u2109");
				textcels.requestFocus();
				textcels.selectAll();
			}// end actionPerformed
		}// end CelsListener
	}//end class ConvertTemp

}
