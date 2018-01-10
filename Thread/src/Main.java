
public class Main {
	public static void main(String args[]){
		ThreadDemo t1 = new ThreadDemo("Thread1");
		ThreadDemo t2 = new ThreadDemo("Thread2");
		t1.start();
		t2.start();		
	}
}
