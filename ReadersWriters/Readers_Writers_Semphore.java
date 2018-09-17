package package2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Readers_Writers_Semphore {
	
	public static void main(String[] args) {

		Database d = new Database();

		Writer w1 = new Writer(d,1);
		Writer w2 = new Writer(d,10);
		Writer w3 = new Writer(d,100);
		Writer w4 = new Writer(d,1000);
		Writer w5 = new Writer(d,10000);
		Reader r1 = new Reader(d);
		Reader r2 = new Reader(d);
		Reader r3 = new Reader(d);
		Reader r4 = new Reader(d);
		Reader r5 = new Reader(d);

		w1.start();
		r1.start();
		r2.start();
		w2.start();
		r3.start();
		r4.start();
		w3.start();
		r5.start();
		w4.start();
		w5.start();

	}
}

class Database {
	int data = 0;
	int r = 0;   // # active readers
	int w = 0;   // # active writers (0 or 1)
	int ww = 0;  // # waiting writers
	int wr = 0; // # waiting readers
	
	Semaphore lock = new Semaphore(1);
	Semaphore readers = new Semaphore(0);
	Semaphore writers = new Semaphore(0);
	
	public void request_read() throws InterruptedException {
		lock.acquire();
		while (w == 1 || ww > 0)   
			try {
				   wr++;  lock.release();readers.acquire();lock.acquire(); wr--; 
			}   catch (Exception e) {
		}
		r++;
		lock.release();
	}

	public void done_read() throws InterruptedException {
		lock.acquire();
		r--;
		if(ww > 0 || w > 0)
			writers.release();
		else
			readers.release();
		lock.release();
	}

	public void request_write() throws InterruptedException {
		lock.acquire();
 		while (r > 0 || w == 1) {
			try {
				 ww++;  lock.release();writers.acquire();lock.acquire();  ww--;
			} catch (Exception e) {}
 		}
		w = 1;
		lock.release();
	}

	public void done_write() throws InterruptedException {
		lock.acquire();
		w = 0;
		
		if(ww == 0) {
			while (readers.hasQueuedThreads()) 
				readers.release();
		}
		
		while (writers.hasQueuedThreads()) 
			writers.release();
	
		lock.release();
	} 

	int read() {
		return data;
	}

	void write(int x) {
		data = data + x;
	}
}

class Reader extends Thread {
	Database d;

	public Reader(Database d) {
		this.d = d;
	}

	public void run() {

		for (int i = 0; i < 5; i++){		
			try {
				d.request_read();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(d.read());
			try {
				Thread.sleep(new Random().nextInt(25));
			}
			catch (Exception e) {}	
			try {
				d.done_read();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class Writer extends Thread {
	Database d;
	int x;

	public Writer(Database d, int x) {
		this.d = d;
		this.x = x;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {			
			try {
				d.request_write();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			d.write(x);
			try {
				Thread.sleep(new Random().nextInt(25));
			}
			catch (Exception e) {}
			try {
				d.done_write();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

