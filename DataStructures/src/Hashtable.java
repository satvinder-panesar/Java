class Student{
		String name;
		String rollno;
		Student(String name, String rollno){
			this.name=name;
			this.rollno = rollno;
		}
	}

public class Hashtable {
	 
	 class Node{
		Student s;
		Node link;
		
		Node(Student s){
			this.s=s;
		}
	}
		Node[] arr;
		
		Hashtable(int size){
			arr = new Node[size];
		}
		
		void insert(Student s){
			int sum = 0;
			for(int i=0; i<s.rollno.length(); i++){
				sum = (int)s.rollno.charAt(i);
				
			}
			int index = sum%arr.length;
			Node student = new Node(s);
			if(arr[index] == null){				
				arr[index] = student;
				System.out.println("Student added");
			}else{
				Node n = arr[index];
				while(n != null){
					if(n.link == null){
						n.link = student;
						break;
					}
					n = n.link;
				}
				System.out.println("Student added");
			}
	}

}
