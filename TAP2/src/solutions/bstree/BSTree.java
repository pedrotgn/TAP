package solutions.bstree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class BSTree<T> implements Iterable<T>{
	
	T data;
	BSTree<T> left;
	BSTree<T> right;
	Comparator<T> comp;
	
	public BSTree(Comparator<T> comp) {
		this.comp = comp;
		this.left = null;
		this.right = null;
		this.data = null;
	}
	public BSTree(Comparator<T> comp, T data) {
		this.comp = comp;
		this.left = null;
		this.right = null;
		this.data = data;
	}
	
	public void insert(T elem){
		if (data==null){
			data = elem;
		}else {
			if (comp.compare(elem,data)<=0){
				if (left == null){
					left = new BSTree<T>(comp,elem);
				}else {
					left.insert(elem);
				}
			}else {
				if (right == null){
					right = new BSTree<T>(comp,elem);
				}else {
					right.insert(elem);
				}
			}
		}
		
	}
	
	public boolean contains(T elem){
		
		if (data.equals(elem)){
			return true;
		}else{
			if (comp.compare(elem,data)<=0){
				if (left!=null)
					return  left.contains(elem);
				else return false;
			} else {
				if (right!=null)
					return right.contains(elem);
				else return false;
			}
		
		}
		
	}
	public Iterator<T> iterator() {
		LinkedList<T> lista = new LinkedList<T>();
		BSTree.tree2list(this, lista);
		return lista.iterator();
	}
	
	public static <T >void tree2list(BSTree<T> arbol,List<T> list){
		if (arbol.getData()!=null){
			list.add(arbol.getData());
			if (arbol.getLeft()!=null)
				BSTree.tree2list(arbol.getLeft(), list);
			if (arbol.getRight()!=null)
				BSTree.tree2list(arbol.getRight(), list);
		}
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BSTree<T> getLeft() {
		return left;
	}
	public BSTree<T> getRight() {
		return right;
	}

}
