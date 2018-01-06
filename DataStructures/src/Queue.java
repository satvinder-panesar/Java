
public class Queue {
	int size;
	int rear;
	Person[] p;
	Queue(int size){
		p = new Person[size];
		this.size = size;
		rear = -1;
	}
	void enqueue(Person p){
		this.p[++rear]=p;
	}
	void dequeue(){
		if(rear == -1)
			System.out.println("Empty queue");
		else if(rear == 0){
			p[0]=null;
			rear--;
		}
		else{
			for(int i=1; i<=rear; i++){
				p[i-1]=p[i];
			}
			p[rear--]=null;
		}
	}
	void printAll(){
		if(rear == -1)
			System.out.println("Empty queue");
		else{
			for(int i=0; i<=rear; i++){
				System.out.println("Items "+p[i]);
			}
		}
	}
}
