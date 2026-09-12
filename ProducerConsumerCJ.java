package ProducerConsumerProblem;

class Buffer{
	 int val;
	 boolean available = false;
	 
	 synchronized void produce(int val) {
		 try {
			 
			 while(available) {
				 wait();
			 }
			 this.val = val;
			 available = true;
			 System.out.println("PRODUCED : "+ val);
			 
			 notify();
		 }catch(InterruptedException e) {
			 System.out.println("producer Interrupted");
		 }
	 }
	 
	 synchronized void consume() {
		 
		 try {
			 while(!available) {
				 wait();
			 }
			 
			 System.out.println("CONSUMED :"+ val);
			 available = false;
			 
			 notify();
		 }catch(InterruptedException e) {
			 System.out.println("Consumer Interrupted");
		 }
	 }
}


class Producer extends Thread {
	
	Buffer buffer;
	
	Producer(Buffer buffer){
		this.buffer= buffer;
	}
	
	public void run() {
		for(int i=1 ; i<=5 ; i++) {
			buffer.produce(i);
		}
	}
}

class Consumer extends Thread {
	Buffer buffer;
	
	Consumer(Buffer buffer){
		this.buffer=buffer;
	}
	
	public void run() {
		
		for(int i=1 ; i<=5 ; i++) {
			buffer.consume();
		}
	}
}

public class ProducerConsumerCJ {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		
		producer.start();
		consumer.start();
	}

}
