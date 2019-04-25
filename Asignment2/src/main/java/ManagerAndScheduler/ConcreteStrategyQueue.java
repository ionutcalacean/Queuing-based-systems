package ManagerAndScheduler;

import java.util.ArrayList;
import java.util.Iterator;

import Server.Server;
import Task.Client;

public class ConcreteStrategyQueue implements Strategy {

	public int addTask(ArrayList<Server> cozi, Client c) {
		Iterator<Server> it = cozi.iterator();
		int minimClienti = 100;
		int index=-2;//initializat pentru a scapa de warning
		while (it.hasNext()) {
			Server curent = it.next();
			int numarClientiCurent = curent.getClienti().size();
			if (numarClientiCurent < minimClienti) {
				minimClienti = numarClientiCurent;
				index=cozi.indexOf(curent);
			}

		}
		cozi.get(index).addClient(c);
		return index;
 
	}
	
	public int getIndex(ArrayList<Server> cozi, Client c)
	{
		Iterator<Server> it = cozi.iterator();
		int minimClienti = 100;
		int index=-2;//initializat pentru a scapa de warning
		while (it.hasNext()) {
			Server curent = it.next();
			int numarClientiCurent = curent.getClienti().size();
			if (numarClientiCurent < minimClienti) {
				minimClienti = numarClientiCurent;
				index=cozi.indexOf(curent);
			}

		}
		return index;
	}
}
