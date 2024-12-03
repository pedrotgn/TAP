package solutions.visitor;

import java.util.LinkedList;
import java.util.List;

public class Directory implements AComponent {

	private String name;
	private List <AComponent> children;
	private AComponent parent = null;
	

	public Directory(String name) {
		this.name = name;
		children = new LinkedList<>();
	}

	public void addChild(AComponent child){
		children.add(child);
		child.setParent(this);
	}

	public void removeChild(AComponent child){
		children.remove(child);
	}
	
	public void ls() {
		System.out.println(name);
		for (AComponent child:children)
			child.ls();
		
	}


	public void setParent(AComponent parent) {
		this.parent = parent;
		
	}
	public String toString(){
		String path="/";
		if (parent!=null)
				path = parent.toString()+ "/";
		return path + name;
	}
	public List<AComponent> toList() {
		List<AComponent> result = new LinkedList<AComponent>();
		result.add(this);
		for (AComponent child:children)
			result.addAll(child.toList());
		return result;
	}

	public List<AComponent> getChildren() {
		return children;
	}

	public void accept(Visitor v) {
	    v.visit(this);
	  }

	
}
