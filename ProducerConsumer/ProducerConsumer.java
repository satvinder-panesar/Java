// HW2:  Outline of Producer-Consumer:

import java.util.Random;

public class ProducerConsumer {
	public static void main(String[] args) {
		DropBox db = new DropBox(5);
		Producer p = new Producer(db);
		Consumer c = new Consumer(db);
		p.start();
		c.start();
		
	}
}

class Producer extends Thread {
	private DropBox db;

	public Producer(DropBox db) {
		this.db = db;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			db.put(i);
			try {
				Thread.sleep(new Random().nextInt(100));
			} catch (Exception e) {
			}
		}
	}
}

class Consumer extends Thread {
	private DropBox db;
	int value;

	public Consumer(DropBox db) {
		this.db = db;
	}

	public void run() {
		while (true) {
			value = db.get();
			try {
				Thread.sleep(new Random().nextInt(500));
			} catch (Exception e) {
			}
		}
	}
}

class DropBox {
	// to be filled in by you
	private int size, p, g, count, lock;
	private int[] buffer;
	DropBox(int size){
		buffer = new int[size];
		this.size = size;
		p = 0;
		g = 0;
		count = 0;
		lock = 1;
	}
	
	boolean empty() {
		if(count == 0)
			return true;
		return false;
	}
	
	boolean full() {
		if(count == size)
			return true;
		return false;
	}
	
	void put(int x) {
		while(lock == 0) {
			//waiting
		}
	    while(full()) {
	    	//waiting
	    	//System.out.println("Full");
	    	try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lock = 0;
		buffer[p] = x;
		if(p == size-1)
			p = 0;
		else
			p++;
		count++;
		System.out.println("Added "+x);
		//System.out.println("p = "+p+" and g = "+g);
		lock = 1;
	}
	
	int get() {
		int x = -999;
		while(lock == 0) {
			//waiting
		}
		while(empty()){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lock = 0;
		x = buffer[g];
		if(g == size-1)
			g = 0;
		else
			g++;
		count--;
		System.out.println("Consumed -- "+x);
		//System.out.println("p = "+p+" and g = "+g);
		lock = 1;
		return x;
	}
}