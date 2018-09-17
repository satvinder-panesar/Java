
import java.util.*;

public class Elevator_Scheduler {

	public static void main(String[] args) {
		
		Elevator E = new Elevator();
			
 		Scheduler S = new Scheduler(E,6);	
 		
		E.S = S;  // added this line for state maintenance											
		
		Person p1 = new Person("A",S);
		Person p2 = new Person("B",S);
		Person p3 = new Person("C",S);	
		Person p4 = new Person("D",S);
		Person p5 = new Person("E",S);
		Person p6 = new Person("F",S);

		p1.start();
		p2.start();
	    p3.start();
	    p4.start();
		p5.start();
	    p6.start();
	    

		S.start();
		
		}
}


class Elevator {
	
	int current_floor;
	String direction;
	
	Scheduler S;    // added this line for state maintenance
	
	String state;   // for query-based debugging 
	
	public Elevator() {
		current_floor = 0;
		direction = "up";
	}
	
	synchronized void go(int floor, String dir) {
		 if (direction.compareTo(dir) != 0)
			direction = dir;
		 if (current_floor != floor)
			current_floor = floor;
		
		String up = S.up.toString();
		String down = S.down.toString();
		
		state = current_floor + "-" + direction + "-" + up + "-" + down;		 
	}
}

class Person extends Thread {
	Scheduler S;
	String name;
	int from = 0;
	int to = 0;
	
	public Person(String name, Scheduler S) {
        this.name = name;
        this.S = S;
    }

	public void run() {
        try {
            while (true) {
        	  if (to > from) 
         		  S.up(name,from, to);
        	  if (from > to) 
        		  S.down(name,from, to);
        	  from = to;
    		  to = (from + new Random().nextInt(97)) % S.max;
            }
        } catch(Exception e){}
    }
}


class Scheduler extends Thread {
	
	int max;
	int current_floor;
	String direction;
	Elevator elevator;
	
	SortedSet<Integer> up = new TreeSet<Integer>();
	SortedSet<Integer> down = new TreeSet<Integer>();

	public Scheduler(Elevator e, int max_floors) {
	      elevator = e;
	      this.max = max_floors;
          current_floor = 0;
	      direction = "up";
	}
	
	public void run() {
		while(true) {
			schedule();
		}
	}

	synchronized void up(String name, int from, int to) {
		// name can be used for printing, if desired
		try {
			up.add(from);   // press up button at floor 'from'
		    notifyAll();
		    
		    while (current_floor != from)
			    wait();
		    
		    up.add(to);    // get into elevator and press up button to 'to'
		    notifyAll();
		    
		    while (current_floor != to)
			    wait();
		    // reach floor 'to'
		}
		catch (Exception e) {}

	}
	synchronized void down(String name, int from, int to) {
		// name can be used for printing
		try {
			down.add(-from); // press down button at floor 'from'
		    notifyAll();
		    
		    while (current_floor != from)
			    wait();
		    
		    down.add(-to);	// get into elevator and press down button to 'to'
		    notifyAll();
		    
		    while (current_floor != to)
			    wait();     
		    // reach floor 'to'	    
		}
		catch (Exception e) {}
	}
	
	synchronized void schedule()  {
		try {
				
		while (up.isEmpty() && down.isEmpty())
			wait();
				
		//At: Floor 5, direction = up, up:[ 5 ] down:[ ]
		Log.print_queues("At: Floor " + current_floor + ", direction = " + direction + ", ", up, down);

		if (current_floor==(max-1)) 
			 direction = "down";
		
	      if (current_floor == 0) 
				 direction = "up";
	      
	      if(up.isEmpty() && direction == "up") 
	    	  direction = "down";
	      
	      if(down.isEmpty() && direction == "down")
	    	  direction = "up";
	      
	      //At: Floor 2, direction = up, up:[ 0 ] down:[ ]
	      if(direction == "up" && current_floor > up.last()) {
	    	  @SuppressWarnings("rawtypes")
			Iterator i = up.iterator();
	    	  while(i.hasNext())
	    		  down.add(-((int) i.next()));
	    	  up.clear();
	    	  direction = "down";
	      }
	      

	      //At: Floor 1, direction = down, up:[ ] down:[ 4 ]
	      if(direction == "down" && current_floor < Math.abs(down.last())) {
	    	  @SuppressWarnings("rawtypes")
			Iterator i = down.iterator();
	    	  while(i.hasNext())
	    		  up.add(Math.abs(((int) i.next())));
	    	  down.clear();
	    	  direction = "up";
	      }
	      
	      if (direction == "up")  {
				 
	    	  if(up.contains(current_floor)) {
	    		  System.out.println("Removing floor no "+current_floor+" from up list");
	    		  up.remove(current_floor);
	    	  }
	    	  
	    	  if(!up.isEmpty() && current_floor < max-1 && current_floor < up.last()) {
	    		  @SuppressWarnings("rawtypes")
	  			Iterator i = up.iterator();
	  	    	  while(i.hasNext()) {
	  	    		  int temp = (int)i.next();
	  	    		  if(current_floor < temp) {
	  	    			  current_floor = temp;
	  	    			  break;
	  	    		  }
	  	    	  }
	    		  elevator.go(current_floor, direction);
	    	  }
	    	  
	    	  if(up.contains(current_floor)) {
	    		  System.out.println("Removing floor no "+current_floor+" from up list");
	    		  up.remove(current_floor);
	    	  }
	    	  
    	  }else{
    		  
        	if(down.contains(-current_floor)) {
        		System.out.println("Removing floor no "+current_floor+" from down list");
	    		  down.remove(-current_floor);
        	}
        	
        	if(!down.isEmpty() && current_floor > 0) {
        		@SuppressWarnings("rawtypes")
	  			Iterator i = down.iterator();
	  	    	  while(i.hasNext()) {
	  	    		  int temp = Math.abs((int)i.next());
	  	    		  if(current_floor > temp) {
	  	    			  current_floor = temp;
	  	    			  break;
	  	    		  }
	  	    	  }
        		elevator.go(current_floor, direction);
        	}
        	
        	if(down.contains(-current_floor)) {
        		System.out.println("Removing floor no "+current_floor+" from down list");
	    		  down.remove(-current_floor);
        	}
        	
         }

	    Log.print_queues("Reached: Floor = " + current_floor + ", direction = " + direction + ", ", up, down);
	    
	    
		notifyAll();
		}

		catch (Exception e) {}
	}
    
}


// For logging output

class Log {
	
	static synchronized void print_queues(String action, SortedSet<Integer> up, SortedSet<Integer> down) {

		System.out.print(action + "up:[ ");

		for (int f: up) 
			System.out.print(f + " ");

		System.out.print("] down:[ ");

		for (int f: down) 
			System.out.print((0-f) + " ");

		System.out.println("]");
	}		 

}



