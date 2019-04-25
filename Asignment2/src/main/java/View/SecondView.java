package View;

import java.awt.*;
import javax.swing.*;

public class SecondView {

	JTextField simTime=new JTextField(40);
	JTextField minArrival=new JTextField(40);
	JTextField maxArrival=new JTextField(40);
	JTextField minProcessing=new JTextField(40);
	JTextField maxProcessing=new JTextField(40);
	JTextField nbOfClients=new JTextField(40);
	JTextField nbOfServers=new JTextField(40);
	String[] sel={"Cel mai scurt timp","Cea mai scurta coada"};
    JComboBox selPolicy=new JComboBox(sel);
    JButton start=new JButton("START");
	
	public SecondView()
	{
		JFrame secondFrame=new JFrame();
		secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		secondFrame.setSize(500, 400);
		secondFrame.setLocation(1000, 400);
		
		JPanel mainPanel=new JPanel();
		JPanel p1= new JPanel();
		JPanel p2=new JPanel();
		
		JLabel simTimeLabel=new JLabel("Simulation Time:");
		JLabel minArrivalL=new JLabel("Minimul Arrival:");
		JLabel maxArrivalL=new JLabel("Maximum Arrival:");
		JLabel minProcessingL=new JLabel("Minimum Processing:");
		JLabel maxProcessingL=new JLabel("Maximum Processing:");
		JLabel nbOfClientsL=new JLabel("Number Of Clients:");
		JLabel nbOfServersL=new JLabel("Number Of Servers:");
		JLabel selPolicyL=new JLabel("Selection Policy:");
		
		p1.add(simTimeLabel);
		p1.add(minArrivalL);
		p1.add(maxArrivalL);
		p1.add(minProcessingL);
		p1.add(maxProcessingL);
		p1.add(nbOfClientsL);
		p1.add(nbOfServersL);
		p1.add(selPolicyL);
		p1.add(start);
		//p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p1.setLayout(new GridLayout(9, 1));
		
		
	    
	    selPolicy.setEditable(false);
	    
	    p2.add(simTime);
	    p2.add(minArrival);
	    p2.add(maxArrival);
	    p2.add(minProcessing);
	    p2.add(maxProcessing);
	    p2.add(nbOfClients);
	    p2.add(nbOfServers);
	    p2.add(selPolicy);
	    p2.setLayout(new GridLayout(9,1));
	    
	    simTime.setText("40");
	    minArrival.setText("1");
	    maxArrival.setText("2");
	    minProcessing.setText("5");
	    maxProcessing.setText("8");
	    nbOfClients.setText("10");
	    nbOfServers.setText("2");
		
		
		mainPanel.add(p1);
		mainPanel.add(p2);
		mainPanel.setLayout(new GridLayout(1,2));
		
		secondFrame.setContentPane(mainPanel);
		secondFrame.setVisible(true);
	}
	
	public int getSimTime()
	{
		String input=simTime.getText();
		int simTime=0;
		try {
			   simTime = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				 JOptionPane.showMessageDialog(null, "Wrong input", "Warning",
					        JOptionPane.WARNING_MESSAGE);
			}
		return simTime;
	}
	
	public int getMinArrival()
	{
		String input=minArrival.getText();
		int minArrival=0;
		try {
			   minArrival = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				 JOptionPane.showMessageDialog(null, "Wrong input", "Warning",
					        JOptionPane.WARNING_MESSAGE);
			}
		return minArrival;
	}
	
	
	public int getMaxArrival() {
		String input=maxArrival.getText();
		int maxArrival=0;
		try {
			   maxArrival = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				 JOptionPane.showMessageDialog(null, "Wrong input", "Warning",
					        JOptionPane.WARNING_MESSAGE);
			}
		return maxArrival;
	}
	
	public int getMinProcessing()
	{
		String input=minProcessing.getText();
		int minProcessing=0;
		try {
			minProcessing = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				 JOptionPane.showMessageDialog(null, "Wrong input", "Warning",
					        JOptionPane.WARNING_MESSAGE);
			}
		return minProcessing;
	}
	
	public int getMaxProcessing()
	{
		String input=maxProcessing.getText();
		int maxProcessing=0;
		try {
			maxProcessing = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				 JOptionPane.showMessageDialog(null, "Wrong input", "Warning",
					        JOptionPane.WARNING_MESSAGE);
			}
		return maxProcessing;
	}
	
	public int getNbOfClients()
	{
		String input=nbOfClients.getText();
		int nbOfClients=0;
		try {
			nbOfClients = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				 JOptionPane.showMessageDialog(null, "Wrong input", "Warning",
					        JOptionPane.WARNING_MESSAGE);
			}
		return nbOfClients;
	}
	
	public int getNbOfServers()
	{
		String input=nbOfServers.getText();
		int nbOfServers=0;
		try {
			nbOfServers = Integer.parseInt(input);
			}
			catch (NumberFormatException e)
			{
				 JOptionPane.showMessageDialog(null, "Wrong input", "Warning",
					        JOptionPane.WARNING_MESSAGE);
			}
		return nbOfServers;
		
	}
	public String getSelPolicy()
	{
		String choice=(String)selPolicy.getSelectedItem();
		return choice;
	}
	
	public JButton getStart()
	{
		return start;
	}
	
	
}
