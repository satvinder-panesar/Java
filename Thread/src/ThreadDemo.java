
public class ThreadDemo extends Thread{
	String threadName;
	ThreadDemo(String threadName){
		this.threadName=threadName;
	}
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println("Executing "+threadName);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
