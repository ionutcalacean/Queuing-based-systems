package ManagerAndScheduler;

import java.util.ArrayList;
import java.util.Iterator;

import Server.Server;
import Task.Client;

public class ConcreteStrategyTime implements Strategy{

	public int addTask(ArrayList<Server> cozi, Client c) {
		// TODO Auto-generated method stub
		Iterator<Server> it = cozi.iterator();
		int minimTimp = Integer.MAX_VALUE;
		int index=-2;//initializat pentru a scapa de warning
		while (it.hasNext()) {
			Server curent = it.next();
			int timpCurent = curent.getWaitingPeriod().intValue();
			if (timpCurent < minimTimp) {
				minimTimp = timpCurent;
				index=cozi.indexOf(curent);
			}

		}
		cozi.get(index).addClient(c);
		return index;
	}
	
	public int getIndex(ArrayList<Server> cozi, Client c)
	{
		Iterator<Server> it = cozi.iterator();
		int minimTimp = Integer.MAX_VALUE;
		int index=-2;//initializat pentru a scapa de warning
		while (it.hasNext()) {
			Server curent = it.next();
			int timpCurent = curent.getWaitingPeriod().intValue();
			if (timpCurent < minimTimp) {
				minimTimp = timpCurent;
				index=cozi.indexOf(curent);
			}

		}
		return index;
	}

}
