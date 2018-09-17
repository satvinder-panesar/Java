// CSE 522: Homework 1, Part 1

class BST_Part1 {
	public static void main(String args[]) {
		
		 Tree tr;
		 tr = new Tree(100);
		 tr.insert(50);
		 tr.insert(125);
		 tr.insert(150);
		 tr.insert(25);
		 tr.insert(75);
		 tr.insert(20);	
		 tr.insert(90);
//		 System.out.println("Min value is "+tr.min().value);
//		 System.out.println("Max value is "+tr.max().value);
//		 System.out.println("Find result for 50 is "+tr.find(50).value);
//		 System.out.println("Find result for 55 is "+tr.find(55));
//		 System.out.println("Parent of node 125 is "+tr.findParent(125).value);
//		 System.out.println("Parent of node 120 is "+tr.findParent(120));
		 tr.delete(20);
		 tr.delete(20);
		 tr.delete(125);
		 tr.delete(150);
		 tr.delete(100);
//		 tr.inorder();
		 tr.delete(50);
		 tr.delete(75);
		 tr.delete(25);
		 tr.delete(90);
		 //tr.inorder();
		 System.out.println("End of main");
	}
}

class Tree { // Defines one node of a binary search tree
	
	public Tree(int n) {
		value = n;
		left = null;
		right = null;
	}
		
	public void inorder() {
		System.out.println("Inorder traversal");
		// TODO Auto-generated method stub
		if(this.left!=null)
			this.left.inorder();
		if(this!=null)
			System.out.println(this.value);
		if(this.right!=null)
			this.right.inorder();
	}

	public void insert(int n) {
		if (value == n)
			return;
		if (value < n)
			if (right == null)
				right = new Tree(n);
			else
				right.insert(n);
		else if (left == null)
			left = new Tree(n);
		else
			left.insert(n);
	}

	
	public Tree min() {
		// returns the Tree node with the minimum value
		// you should write the code
		Tree tree = this;
		while(tree.left!=null) {
			tree=tree.left;
		}
		return tree;
	}
	
	public Tree max() {
		// returns the Tree node with the maximum value
		// you should write the code
		Tree tree = this;
		while(tree.right!=null) {
			tree=tree.right;
		}
		return tree;
	}
	
	
	public Tree find(int n) {
		// returns the Tree node with value n
		// returns null if n is not present in the tree
		// you should write the code
		Tree tree = this;
		while(tree!=null) {
			if(tree.value == n)
				return tree;
			if(tree.value<n) 
				tree=tree.right;
			else
				tree=tree.left;
		}
		return null;
	}
	
	public Tree findParent(int n) {
		// returns the Tree node with value n
		// returns null if n is not present in the tree
		// you should write the code
		Tree tree = this;
		while(tree!=null) {
			if(tree.left!=null && tree.left.value==n)
				return tree;
			if(tree.right!=null && tree.right.value==n)
				return tree;
			if(tree.value<n) 
				tree=tree.right;
			else
				tree=tree.left;
		}
		return null;
	}
	
	public void delete(int n) {  
		Tree t = find(n);
		if (t == null) {  
			// print out error message and return
			System.out.println("Node "+n+" not found");
			return;
		}
		
		if(t == this && t.left==null && t.right==null) {
			System.out.println("Cannot delete the only root node");
			return;
		}
		
		if (t.left == null && t.right == null) { 
			// do case1 and return
			case1(t,this);
			return;
		}
		if (t.left == null || t.right == null) {  
			if (t != this) { 
				// do case2 and return
				case2(t,this);
				return;
			} else {
				// do case3 and return
				if(t.left!=null)
					case3(t,"left");
				else
					case3(t,"right");
				return;
			}
		}
		// do case3 and return
		case3(t,"left");
		return;		
	}
	
	private void case1(Tree t, Tree root) {
		Tree parent=findParent(t.value);
		if(parent!=null)
			if(parent.left!=null && parent.left.value==t.value)
				parent.left=null;
			else
				parent.right=null;
		int temp=t.value;
		t=null;
		System.out.println("Node "+temp+" deleted-Case1");
	}
	
	private void case2(Tree t, Tree root) {  
		Tree parent=findParent(t.value);
		if(parent!=null) {
			if(parent.left.value==t.value) {
				if(parent.left.right!=null)
					parent.left=parent.left.right;
				else
					parent.left=parent.left.left;
			}
			else
				if(parent.right.left!=null)
					parent.right=parent.right.left;
				else
					parent.right=parent.right.right;
		}
			
		int temp=t.value;
		t.right=null;
		t.left=null;
		t=null;
		System.out.println("Node "+temp+" deleted-Case2");
	}
	
	private void case3(Tree t, String which_side) {  
		// which == "left" or which == "right"
		Tree adjust;
		if(which_side=="left")
			adjust=t.left.max();
		else
			adjust=t.right.min();
		System.out.println("Node "+t.value+" deleted-Case3");
		delete(adjust.value);	
		t.value=adjust.value;
 	}

	protected int value;
	protected Tree left;
	protected Tree right;
}

























