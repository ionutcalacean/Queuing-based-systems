package ManagerAndScheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Server.Server;
import Task.Client;
import View.SecondView;
import View.View;

public class SimulationManager implements Runnable{
	
	public int timeLimit=200;
	public int numberOfClients;
	public int numberOfServers;
	public int maxProcessingTime;
	public int minProcessingTime;
	public int minArrivalTime;
	public int maxArrivalTime;
    public String selectionPolicy;
    private double avgProcessing=0,avgWaiting=0,peakTime=0;
    
    private Scheduler scheduler;
    private View view;
    private SecondView secView;
    private ArrayList<Client> clienti;
    
    private static int start=0;
    
    public SimulationManager(SecondView view)
    {
    	this.view=new View();
    	secView=view;
    	numberOfClients=secView.getNbOfClients();
    	numberOfServers=secView.getNbOfServers();
    	maxProcessingTime=secView.getMaxProcessing();
    	minProcessingTime=secView.getMinProcessing();
    	minArrivalTime=secView.getMinArrival();
    	maxArrivalTime=secView.getMaxArrival();
    	timeLimit=secView.getSimTime();
    	selectionPolicy=secView.getSelPolicy();
    	
    	
    	
    	clienti=generateNRandomClients(numberOfClients);
    	
    }
	
    public ArrayList<Client> generateNRandomClients(int numberOfClients)
    {
    	ArrayList<Client> clienti=new ArrayList<Client>();
    	Random rand=new Random();
    	int processingTime=0,arrivalTime=0;
    	int predArr=0;
    	for(int i=0;i<numberOfClients;i++)
    	{
    		processingTime=rand.nextInt(maxProcessingTime - minProcessingTime+1)+minProcessingTime;
    		arrivalTime=rand.nextInt(maxArrivalTime-minArrivalTime+1)+minArrivalTime+predArr;
    		predArr=arrivalTime;
    		Client c=new Client(arrivalTime,processingTime);
    		clienti.add(c);
    	}
    	return clienti;
    }
    
    public void preRun()
    {
    	secView.getStart().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SimulationManager.start=1;
			}
			
		});
    	while(true)
		{
		   if(start == 1)
			{
				Thread t=new Thread(this);
				t.start();
				break;
			
			}
			System.out.println("");
		}
    }
    
	public void run() {
		// TODO Auto-generated method stub
		scheduler=new Scheduler(numberOfServers,numberOfClients,view);
         for(int i=0;i<numberOfServers;i++)
    	{	
    		(new Thread(scheduler.getCozi().get(i))).start();
    	}
    	scheduler.changeStrategy(selectionPolicy);
		
		
		view.creareCozi(numberOfServers);
		view.repaintQueues();
		int currentTime=1;
		int index=-1;
		while(currentTime<timeLimit)
		{
			int currentWaitingTime=0;;
			for(Server q: scheduler.getCozi())
				currentWaitingTime += q.getWaitingPeriod().intValue();
			int maximWaiting=0;
			if(maximWaiting<currentWaitingTime) {
				maximWaiting=currentWaitingTime;
				peakTime=currentTime;
			}
			
			
			for(Client c:clienti)
			{
				index=scheduler.getIndex(c);
				if(c.getArrivalTime()==currentTime)
				{
					c.setFinishTime(c.getArrivalTime()+c.getProcessingTime()+scheduler.getCozi().get(index).getWaitingPeriod().intValue());
					c.setCoada(index+1);
					avgProcessing+=c.getProcessingTime();
					avgWaiting+=c.getFinishTime()-c.getArrivalTime();
					scheduler.expediereClient(c);
					view.getLogOfEvents().append("Client adaugat la coada "+ (index+1)+" la momentul:"+c.getArrivalTime()+" service:"+c.getProcessingTime()+" finish:"+c.getFinishTime()+"\n");
					view.adaugareClient(index);
					
				}
				if(c.getFinishTime()==currentTime)
				{
					view.getLogOfEvents().append("Client scos din coada "+c.getCoada()+" momentul "+currentTime+"\n");
				}
				
			}

			view.setCurrTime(currentTime);
			currentTime++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Cannot sleep simulation thread");
				e.printStackTrace();
			}
		}
		setResults();
	}
	
	public void setResults()
	{
	     avgProcessing/=numberOfClients;
	     avgWaiting/=numberOfClients;
		 JOptionPane.showMessageDialog(null, "Average Processing:"+avgProcessing+"\n"+"Average Waiting:"+avgWaiting+"\n"+"Peak time:"+peakTime+"\n", "Simulation results",
			        JOptionPane.WARNING_MESSAGE);
	}

}
