package lab3;

public class Vertex<E> {

	public Vertex<E> parent;
	public Vertex<E> leftChild;
    public Vertex<E> middleChild;
	public Vertex<E> rightChild;
	public E label;
	
	public Vertex(Vertex<E> parent, Vertex<E> leftChild, Vertex<E> middleChild, Vertex<E> rightChild, E label) {
		this.parent = parent;
		this.leftChild = leftChild;
        this.middleChild = middleChild;
		this.rightChild = rightChild;
		this.label = label;
	}
	
	public Vertex<E> addLeftChild(E label) {
		leftChild = new Vertex<E>(this, null, null, null, label);
		return leftChild;
	}

    public Vertex<E> addMiddleChild(E label) {
		middleChild = new Vertex<E>(this, null, null, null, label);
		return middleChild;
	}
	
	public Vertex<E> addRightChild(E label) {
		rightChild = new Vertex<E>(this, null, null, null, label);
		return rightChild;
	}

    public String toString() {
        return this.label.toString();
    }
	
}
