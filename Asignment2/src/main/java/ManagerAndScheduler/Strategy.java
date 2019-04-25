package ManagerAndScheduler;

import java.util.ArrayList;

import Server.Server;
import Task.Client;

public interface Strategy {

	public int addTask(ArrayList<Server> cozi,Client c);
	public int getIndex(ArrayList<Server> cozi, Client c);
}
