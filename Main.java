package lab3;

public class Main {

	public static void main(String[] args) {
		TernaryTree<String> myTree = new TernaryTree<String>(new Vertex<String>(null, null, null, null, "D"));
		myTree.root.addLeftChild("A").addLeftChild("R");
		myTree.root.addMiddleChild("N").addLeftChild("Z").addRightChild("K");
		myTree.root.middleChild.addMiddleChild("A").addMiddleChild("B");
		myTree.root.leftChild.addMiddleChild("E");
		myTree.root.leftChild.addRightChild("P");
		myTree.root.addRightChild("Q").addLeftChild("T").addLeftChild("A").addRightChild("W");
		myTree.root.rightChild.leftChild.addRightChild("M");
		
		// Sanity Check 1
		System.out.println("Expected output: [D, A, R, E, P, N, Z, K, A, B, Q, T, A, W, M]");
		System.out.println("Actual output: " + myTree.preorder());
		System.out.println();
		
		// Sanity Check 2
		System.out.println("Expected output: [R, E, P, A, K, Z, B, A, N, W, A, M, T, Q, D]");
		System.out.println("Actual output: " + myTree.postorder());
		System.out.println();
		
		// Sanity Check 3
		System.out.println("Expected output: 15");
		System.out.println("Actual output: " + myTree.getSize());
		System.out.println();
		
		// Sanity Check 4
		System.out.println("Expected output: [R, E, P, K, B, W, M]");
		System.out.println("Actual output: " + myTree.getLeafVertices());
		System.out.println();
		
		// Sanity Check 5
		System.out.println("Expected output: [D, N, Z, K, Q, T, M]");
		myTree.remove("A");
		System.out.println("Actual output: " + myTree.preorder());
		System.out.println();
	}

}
