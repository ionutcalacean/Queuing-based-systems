package pt2019.Asignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ManagerAndScheduler.SimulationManager;
import View.SecondView;

public class App 
{
	private static boolean start=false;
    public static void main( String[] args )
    {
       System.out.println( "Hello World!" );
       SecondView my=new SecondView();
       //View myView=new View();
       
       my.getStart().addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		    start=true;	 
		}
    	   
       });
       
       while(true)
       {
    	   System.out.println("");
    	   if(start)
    	   {
    		   SimulationManager sim=new SimulationManager(my);
    	       Thread t=new Thread(sim);
    	       t.start();
    	       break;
    	   }
       }
       
       
    	   
   
    }
}
