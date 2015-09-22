package solutions.filesystem;

import java.util.LinkedList;
import java.util.List;

public class Directory implements AComponent {

	private String name;
	private List <AComponent> children;
	private AComponent parent = null;
	

	public Directory(String name) {
		this.name = name;
		children = new LinkedList<AComponent>();
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

	public List<String> collect() {
		List<String> result = new LinkedList<String>();
		result.add(name);
		for (AComponent child:children)
			result.addAll(child.collect());
		return result;
	}

	public List<File> search(String name) {
		List<File> result = new LinkedList<File>();
		for (AComponent child:children)
			result.addAll(child.search("lp"));
		return result;
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


	public int size() {
		int result = 0;
		for (AComponent child:children)
			result = result + child.size();
		return result;
	}
	
}
