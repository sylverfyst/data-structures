Public class BinaryTree<T extends Comparable<? super T>> {
	private Node<T> root;
	
	/*
	*  constructor
	*/
	public Tree() {
		root = null;
	}
	
	/*
	*  Method to check if the tree is empty
	*/
	public isEmpty() {
		if(root == null) {
			return false;
		}
		else
			return true;
	}
	/*
	*  Insert method for the binary tree (recursive version, will look at more OOP version later)
	*/
	public void insert(T d) {
		root = insert(T d, null);
	}
	/*
	*  Recursive method to insert a node into a binary tree, because we're using generics,
	*  We can't just use <, we have to use the Comparable interface's compareTo method.  
	*/
	public BinaryNode<T> insert(T d, BinaryNode<T> n) {
		// Tree is empty, so go ahead and just return the new node and set this as the root.
		if(n == null) {
			n = new BinaryNode<T>(d);
		}
		//smaller nodes go to the left, set the new node's left child to insert a new branch with the left child of the node
		//which will recursively travel down the branch (left in this case) filling either left or right wherever the nodes may be.
		else if((d.compareTo(n.getData())) < 0) {
			n.setLeft(insert(d , n.getLeft()));
		}
		//larger (or equal to, I'm not sure of the general convention for nodes that are equal to the parent, but I'm gonna go with right branch)
		//nodes go to the right, set the new node's right child to insert a new branch with the right child of the node
		//which will recursively travel down the branch (right in this case) filling either left or right wherever the nodes may be.
		else {
			n.setRight(insert(d, n.getRight()));
		}
		return n;
	}
	/*
	*  Method to search the tree for a given piece of data	
	*/
	public boolean search(T data) {
		return search (root, data);
	}
	
	/*
	*  Recursive look up for search method.  
	*/
	public boolean search (BinaryNode<T> r, T d) {
		if (r == null){
			return false;
		}
		else if((r.getData().compareTo(d)) < 0 && r.getLeft() != null){
			return r.getLeft().search(r.getLeft(), d);
		}
		else if((r.getData().compareTo(d)) < 0 && r.getLeft() == null){
			return false;
		}
		else if((r.getData().compareTo(d)) > 0 && r.getRight() != null){
			return r.getRight().search(r.getRight(), d);
		else if((r.getData().compareTo(d)) > 0 && r.getRight() == null){
			return false;
		else if((r.getData().compareTo(d)) == 0) {
			return true;
		}
		else
			throw new RuntimeException("You really shouldn't reach this part.");
	}
	
	/*
	*  New Node Class Built for Binary Tree, needed for links to children
	*/
	private class BinaryNode<T> {
		private T data;
		private BinaryNode<T> left;
		private BinaryNode<T> right;
		
		public BinaryNode<T>(T d) {
			data = d;
			left = null;
			right = null;
		}
		public T getData() {
			return data;
		}
		public BinaryNode<T> getLeft() {
			return left;
		}
		public BinaryNode<T> getRight() {
			return right;
		}
		public void setData(T d) {
			data = d;
		}
		public void setLeft(T d) {
			left = new BinaryNode<T>(d);
		}
		public void setRight(T d) {
			right = new BinaryNode<T>(d);
		}
	}
}