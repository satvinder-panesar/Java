public class BST {
	class Node{
		int value;
		Node rc;
		Node lc;
		
		Node(int value, Node lc, Node rc){
			this.value=value;
			this.lc=lc;
			this.rc=rc;
		}
	}
	Node root;
	
	void insert(int value){		
		if(root==null)
			root=new Node(value,null,null);
		else{
			Node node=root;
			while(node!=null){
				if((node.value<value && node.rc==null) || (node.value>value && node.lc==null))
					break;
				else if(node.value<value)
					node=node.rc;
				else
					node=node.lc;
			}
			if(node.value<value)
				node.rc=new Node(value,null,null);	
			else
				node.lc=new Node(value,null,null);
		}
		System.out.println("Insertion done");
	}
	
	void find(int value){		
		if(root==null)
			System.out.println("Empty tree");
		else{
			if(root.value == value)
				System.out.println("Found");
			else{
				Node n = root;
				while(n!=null){
					if((n.lc!=null && n.lc.value==value) || (n.rc!=null && n.rc.value==value)){
						break;
					}
					else if(n.value < value)
						n=n.rc;
					else
						n=n.lc;
					
				}
				if(n==null)
					System.out.println("Not Found");
				else
					System.out.println("Found");
			}
		}
	}
	
	Node getRoot(){
		return root;
	}
	
	void print(Node n){
		//pre-order traversal
		if(n!=null){
			System.out.println(n.value);
			print(n.lc);
			print(n.rc);
		}
	}
}
