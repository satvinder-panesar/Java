//implementation of doubly non-circular linked list
public class LinkedList {
	class Node{
		Person person;
		Node flink;
		Node blink;
		Node(Person value){
			this.person=value;
		}
	}
	Node head;
	Node tail;
	LinkedList(){
		head = new Node(new Person("","",0));
		tail = new Node(new Person("","",0));
		head.flink=null;
		head.blink=null;
		tail.flink=null;
		tail.blink=null;
	}
	void add(Person p){
		Node n = new Node(p);
		if(head.flink==null){
			head.flink = n;
			n.flink = tail;
			n.blink = head;
		}
		else{
			Node node = head.flink;
			while(node.flink != tail){
				node = node.flink;
			}
			node.flink=n;	
			n.flink = tail;
			n.blink=node;
		}
	}
	void print(){
		Node n = head.flink;
		while(n.flink != null){
			System.out.println(n.person);
			n = n.flink;
		}
	}
}
