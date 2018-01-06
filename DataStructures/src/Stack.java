
public class Stack {
	int size;
	int top;
	Person[] stack;
	Stack(int size){
		this.size=size;
		top=-1;
		stack = new Person[size];
	}
	void push(Person p){
		if(top!=(size-1)){
			stack[++top]=p;
		}else
			System.out.println("Stack full");
	}
	Person pop(){
		if(top==-1){
			System.out.println("Stack empty");
			return null;
		}
		else{
			return stack[top--];
		}
	}
	void print(){
		if(top == -1)
			System.out.println("Stack empty");
		else{
			System.out.println("Printing stack");
			for(int i=0; i<=top; i++){
				System.out.println(stack[i]);
			}
		}
		System.out.println("**************");		
	}
}
