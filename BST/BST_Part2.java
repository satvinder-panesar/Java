//CSE 522: Homework 1, Part 2

  class BST_Part2 {

	  public static void main(String[] args) {
		  
			 AbsTree tr = new DupTree(100);
			 //AbsTree tr = new Tree(100);
			 tr.insert(50);
			 tr.insert(125);
			 tr.insert(150);
			 tr.insert(25);
			 tr.insert(75);
			 tr.insert(20);	
			 tr.insert(90);
			 tr.insert(50);
			 tr.insert(125);
			 tr.insert(150);
			 tr.insert(25);
			 tr.insert(75);
			 tr.insert(20);	
			 tr.insert(90);
		
			 tr.delete(20);
			 tr.delete(20);
			 tr.delete(20);
			 tr.delete(150);
			 tr.delete(100);
			 tr.delete(150);
			 tr.delete(125);
			 tr.delete(125);
			 tr.delete(50);
			 tr.delete(50);
			 tr.delete(25);
			 tr.delete(50);
			 tr.delete(75);
			 tr.delete(90);
			 tr.delete(25);
			 tr.delete(50);
			 tr.delete(75);
			 tr.delete(90);
//			 tr.inorder();
			 System.out.println("End of main");		 
		}
  }
  
  abstract class AbsTree {

	public AbsTree(int n) {
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
			count_duplicates();
		else if (value < n)
			if (right == null)
				right = add_node(n);
			else
				right.insert(n);
		else if (left == null)
			left = add_node(n);
		else
			left.insert(n);
	}
	
	public void delete(int n) { // assume > 1 nodes in tree
		AbsTree t = find(n);
		
		// adapt Part 1 solution here
		if (t == null) {  
			// print out error message and return
			System.out.println("Node "+n+" not found");
			return;
		}
		
		if(t == this && t.left==null && t.right==null) {
			System.out.println("Cannot delete the only root node");
			return;
		}
		
		if(t.getCount()!=1) {
			t.decrementCount();
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
	
	protected void decrementCount() {
		// TODO Auto-generated method stub
		
	}

	protected int getCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	protected void case1(AbsTree t, AbsTree root) {  
		AbsTree parent=findParent(t.value);
		if(parent!=null)
			if(parent.left!=null && parent.left.value==t.value)
				parent.left=null;
			else
				parent.right=null;
		int temp=t.value;
		t.setCount(0);
		t=null;
		System.out.println("Node "+temp+" deleted-Case1");
	}
	
	protected void case2(AbsTree t, AbsTree root) {
		AbsTree parent=findParent(t.value);
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
		t.setCount(0);
		t.right=null;
		t.left=null;
		t=null;
		System.out.println("Node "+temp+" deleted-Case2");
	}
	
	protected void case3(AbsTree t, String side) {
		AbsTree adjust;
		if(side=="left")
			adjust=t.left.max();
		else
			adjust=t.right.min();
		System.out.println("Node "+t.value+" deleted-Case3");
		int initCount = adjust.getCount();
		adjust.setCount(1);
		delete(adjust.value);	
		t.value=adjust.value;
		t.setCount(initCount);
	}

	protected void setCount(int value) {
		// TODO Auto-generated method stub
		
	}

	private AbsTree find(int n) {
		AbsTree tree = this;
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
	
	public AbsTree findParent(int n) {
		// returns the Tree node with value n
		// returns null if n is not present in the tree
		// you should write the code
		AbsTree tree = this;
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
	
	public AbsTree min() {
		AbsTree tree = this;
		while(tree.left!=null) {
			tree=tree.left;
		}
		return tree;
	}

	public AbsTree max() {
		AbsTree tree = this;
		while(tree.right!=null) {
			tree=tree.right;
		}
		return tree;
	}

	protected int value;
	protected AbsTree left;
	protected AbsTree right;

	// Protected Abstract Methods
	
	protected abstract AbsTree add_node(int n);
	protected abstract void count_duplicates();

	// additional protected abstract methods, as needed
}


class Tree extends AbsTree {

	public Tree(int n) {
		super(n);
	}

	protected AbsTree add_node(int n) {
		return new Tree(n);
	}

	protected void count_duplicates() {
		System.out.println("Duplicate value discarded for node "+this.value);
	}
	
	// additional protected methods, as needed

}

class DupTree extends AbsTree {

	public DupTree(int n) {
		super(n);
		count = 1;
	};

	protected AbsTree add_node(int n) {
		return new DupTree(n);
	}

	protected void count_duplicates() {
		this.count++;
		System.out.println("Duplicate value recorded for node "+this.value);
	}
	
	
	
	// additional protected methods, as needed

	@Override
	protected int getCount() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	protected void decrementCount() {
		// TODO Auto-generated method stub
		System.out.println("Decrementing node count from "+this.count+" to "+--this.count+" for node "+this.value);
	}
	
	
	@Override
	protected void setCount(int value) {
		// TODO Auto-generated method stub
		this.count=value;
	}


	protected int count;
}