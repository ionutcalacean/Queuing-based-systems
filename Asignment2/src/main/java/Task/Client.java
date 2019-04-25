package Task;

public class Client {
      private int arrivalTime;
      private int processingTime;
      private int finishTime;
      private int coada;
	
      public Client(int arrivalTime, int processingTime) {
		super();
		this.arrivalTime = arrivalTime;
		this.processingTime = processingTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getCoada() {
		return coada;
	}

	public void setCoada(int coada) {
		this.coada = coada;
	}
      
     
}
