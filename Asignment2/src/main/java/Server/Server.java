package Server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import Task.Client;
import View.View;

public class Server implements Runnable{
	
	private AtomicInteger waitingPeriod;
    private BlockingQueue<Client> clienti;
    private View myView;
    private int numarulCozii;
  
    
    public Server(int numarMaximClienti,View view,int nrCoada)
    {
    	clienti=new ArrayBlockingQueue<Client>(numarMaximClienti);
    	waitingPeriod=new AtomicInteger(0);
        numarulCozii=nrCoada;
    	myView=view;
    }
    
    public void addClient(Client c)
    {
    	clienti.offer(c);
    	waitingPeriod.addAndGet(c.getProcessingTime());
    }
	
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			Client processed=clienti.peek();
			if(processed != null)
			{
				if(processed.getProcessingTime()==0)
				{
					clienti.poll();
					myView.stergereClient(numarulCozii);
					processed=clienti.peek();
				}
				 if(processed!=null) {
					processed.setProcessingTime(processed.getProcessingTime()-1);
					waitingPeriod.addAndGet(-1);				
			
				 }
			
		    }
			
			try {

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		/*while(true)
		{
			Client processed=clienti.peek();
			try {
				if(processed!=null) {
					
				   Thread.sleep(processed.getProcessingTime()*1000);
				   waitingPeriod.addAndGet((-1)*processed.getProcessingTime());
				   currentTime+=processed.getProcessingTime();
				   clienti.poll();
				   numarClienti++;
				   myView.stergereClient(numarulCozii);
				}
			} catch (InterruptedException e) {
				System.out.println("Cannot sleep Server Thread");
				e.printStackTrace();
			}
			
			
			
			
		}*/
	}

	public AtomicInteger getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(AtomicInteger waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}

	public BlockingQueue<Client> getClienti() {
		return clienti;
	}

	public void setClienti(BlockingQueue<Client> clienti) {
		this.clienti = clienti;
	}
	

}
