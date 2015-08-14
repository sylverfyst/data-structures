Public class BinaryTree<T> {
	private Node<T> parent;
	private boolean isLeaf;
	
	public Tree() {
		parent = null;
		isLeaf = true;
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