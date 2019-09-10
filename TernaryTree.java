package lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TernaryTree<E> {

	public Vertex<E> root;
	
	public TernaryTree(Vertex<E> root) {
		this.root = root;
	}
	
    // Problem 1: Fill in the methods preorder and postorder below.
	// These methods should traverse the TernaryTree adding vertices
	// to a list in the specified order.  Then, the list of vertices
	// should be returned.
	// expect : [D, A, R, E, P, N, Z, K, A, B, Q, T, A, W, M]
	//RLMR
	//pass list as parameter
	public List<Vertex<E>> preorder() { 
		List<Vertex<E>> verts = new ArrayList();
		return recursivePreorder(root, verts);
	}
	
	public List<Vertex<E>> recursivePreorder(Vertex<E> current, List<Vertex<E>> vert) {
		vert.add(current);
		if(current != null) {
			recursivePreorder(current.leftChild, vert); 
			recursivePreorder(current.middleChild, vert); 
			recursivePreorder(current.rightChild, vert);
			for(int i = 0; i < vert.size(); i++) {
				if(vert.get(i) == null) {
					vert.remove(i);
				}
			}
			return vert;
		}
        else {
            return vert;
        }
	}

	public List<Vertex<E>> postorder() {
		List<Vertex<E>> verts = new ArrayList();
		return recursivePostorder(root, verts);
	}
	
	public List<Vertex<E>> recursivePostorder(Vertex<E> current, List<Vertex<E>> vert) {
		if(current != null) {
			recursivePostorder(current.leftChild, vert); 
			recursivePostorder(current.middleChild, vert); 
			recursivePostorder(current.rightChild, vert);
			vert.add(current);
			for(int i = 0; i < vert.size(); i++) {
				if(vert.get(i) == null) {
					vert.remove(i);
				}
			}
			return vert;
		}
        else {
            return vert;
        }
	}

    // Problem 2: Fill in the method getSize below.
	// This method should use recursion to compute the total number
	// of vertices in the TernaryTree.
    public int getSize() {
    	int x = 0;
    	List<Vertex<E>> verts = new ArrayList();
    	return sizeOf(root, x, verts);
    }
    public int sizeOf(Vertex<E> current, int x, List<Vertex<E>> verts) {
    	if(current != null) {
    		sizeOf(current.leftChild, x, verts); 
			sizeOf(current.middleChild, x, verts); 
			sizeOf(current.rightChild, x, verts);
			verts.add(current);
			return verts.size();
    	}
        else {
            return verts.size();
        }
    }	
    
    // Problem 3: Fill in the method getLeafVertices below.
    // This method should return a list of all vertices that are
    // leafs in the TernaryTree.
    public List<Vertex<E>> getLeafVertices() {
    	List<Vertex<E>> verts = new ArrayList();
    	return recursiveLeaf(root, verts);
    }
    
    public List<Vertex<E>> recursiveLeaf(Vertex<E> current, List<Vertex<E>> vert){
    	if(current != null) {
    		recursiveLeaf(current.leftChild, vert); 
    		recursiveLeaf(current.middleChild, vert); 
    		recursiveLeaf(current.rightChild, vert);
    			if(current.leftChild == null && current.rightChild == null && current.middleChild == null) {
    				vert.add(current);
    				return vert;
    			}
    		return vert;
    	}	
    	else {
    		return vert;
    	}
    } 
	   // Problem 4: Fill in the method remove below.
    // This method should remove all vertices (and their subtrees)
    // that contain the given label.  This method should call
    // the equals method to make comparisons.
    public void remove(E label) {
    	Vertex<E> cur = root;
    	E given = label;
    	recursiveRemove(given, cur);
    	return;
    }
    public void recursiveRemove(E given, Vertex<E> cur) {
    	if(cur == null) {
    		return;
    	}
    	else if(cur != null) {
    		recursiveRemove(given, cur.leftChild);
    	    recursiveRemove(given, cur.rightChild);
    	    recursiveRemove(given, cur.middleChild);
    		if(cur.label.equals(given)) {
    			
    			if(cur.parent.leftChild != null) {
    				if(cur.parent.leftChild.label.equals(given)) {
        				cur.parent.leftChild = null;
        			}
    			}
    			if(cur.parent.rightChild != null) {
    				if(cur.parent.rightChild.label.equals(given)) {
    					cur.parent.rightChild = null;
    				}
    			}
    			if(cur.parent.middleChild != null){
    				if(cur.parent.middleChild.label.equals(given)) {
    					cur.parent.middleChild = null;
    				}
    			}
    			else {
    				return;
    			}
    			cur = null;
    		}
    	}
    	else {
    		return;
    	}	
    }
}
