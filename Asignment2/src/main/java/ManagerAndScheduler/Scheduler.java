package ManagerAndScheduler;

import java.util.ArrayList;

import Server.Server;
import Task.Client;
import View.View;

public class Scheduler {
	private ArrayList<Server> cozi;
	private int numarCozi;
	private int numarClientiMaxim;
	private Strategy strategy;
	private View myView;
	
	public Scheduler(int numarCozi,int numarClientiMaxim,View view)
	{
		cozi=new ArrayList<Server>();
		myView=view;
		for(int i=0;i<numarCozi;i++)
		{
			cozi.add(new Server(numarClientiMaxim,myView,i));
		}
		
	}
	
	public void changeStrategy(String policy)
	{
		
		if(policy.compareTo("Cel mai scurt timp")==0)
			strategy=new ConcreteStrategyTime();
		else if(policy.compareTo("Cea mai scurta coada")==0)
			strategy=new ConcreteStrategyQueue();
	}

	public int expediereClient(Client c)
	{
		int index=strategy.addTask(cozi, c);
		return index;
	}
	
	public int getIndex(Client c) {
		int index=strategy.getIndex(cozi, c);
		return index;
	}
	public ArrayList<Server> getCozi() {
		return cozi;
	}

	public void setCozi(ArrayList<Server> cozi) {
		this.cozi = cozi;
	}

	
}
