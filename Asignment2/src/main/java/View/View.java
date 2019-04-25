package View;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class View {
    public SecondView secondFrame;
	JTextArea logOfEvents=new JTextArea(10,40);
	RepaintedPanel repaintedPanel=new RepaintedPanel();
	ArrayList<JTextArea> cozi=new ArrayList<JTextArea>();
	JTextField currTimef=new JTextField(2);
	
	public View()
	{
		JFrame mainFrame=new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(600, 800);
		mainFrame.setLocation(300, 200);
		
		secondFrame=new SecondView();
		
		JPanel mainPanel=new JPanel();
		JPanel downPanel=new JPanel();
		JPanel upPanel=new JPanel();
		downPanel.setBorder(new TitledBorder(new EtchedBorder(),"Log Of Events"));
		logOfEvents.setEditable(false);
		JScrollPane scroll=new JScrollPane(logOfEvents);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		upPanel.setSize(new Dimension(500,400));
		upPanel.setPreferredSize(new Dimension(500,400));
		//this.creareCozi(6);
		//this.repaintQueues();
		JPanel upTimePanel=new JPanel();
	    JLabel currTime=new JLabel("Current time:");
	    
	    upTimePanel.add(currTime);
	    upTimePanel.add(currTimef);
	    currTimef.setEditable(false);
	    
		upPanel.add(upTimePanel);
		upPanel.add(repaintedPanel);
		upPanel.setLayout(new BoxLayout(upPanel,BoxLayout.Y_AXIS));
		mainPanel.add(upPanel);
		//downPanel.setPreferredSize(new Dimension(300,200));
		downPanel.add(scroll);
		mainPanel.add(downPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.setVisible(true);
	}
	
	public void creareCozi(int nbOfQueues)
	{
		for(int i=0;i<nbOfQueues;i++)
		{
			JPanel temp=new JPanel();
			temp.setSize(new Dimension(500,30));
			temp.setPreferredSize(new Dimension(500,30));
			JLabel jl=new JLabel("Q"+(i+1)+"");
			JTextArea jt=new JTextArea();
			jt.setSize(new Dimension(350,35));
			jt.setPreferredSize(new Dimension(350,35));
			jt.setLineWrap(true);
			this.cozi.add(jt);
			
			temp.add(jl);
			temp.add(jt);
			
			//temp.setLayout(new BoxLayout(temp,BoxLayout.X_AXIS));
			
			this.repaintedPanel.add(temp);
		}
		this.repaintedPanel.add(Box.createVerticalGlue());
		this.repaintedPanel.setLayout(new BoxLayout(repaintedPanel,BoxLayout.Y_AXIS));
	}
	
	public void repaintQueues()
	{
		this.repaintedPanel.repaint();
	}
	
	public void adaugareClient(int nrCoada)
	{
		this.cozi.get(nrCoada).append("C-");
	}
	
	public void stergereClient(int nrCoada)
	{
		String substr=this.cozi.get(nrCoada).getText().substring(2,this.cozi.get(nrCoada).getText().length() );
		this.cozi.get(nrCoada).setText(substr);
	}
	
	public void setCurrTime(int time)
	{
		String timeS=String.valueOf(time);
		currTimef.setText(timeS);
	}

	public JTextArea getLogOfEvents() {
		return logOfEvents;
	}

	public void setLogOfEvents(JTextArea logOfEvents) {
		this.logOfEvents = logOfEvents;
	}
	
	

}
