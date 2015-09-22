package solutions.filesystem2;

import java.util.LinkedList;
import java.util.List;

public class File implements AComponent {

	private String name;
	private int size;
	private AComponent parent;
	
	public File(String name) {
		this.name = name;
	}

	public void ls() {
		System.out.println(name);
		
	}

	public List<String> collect() {
		List<String> result = new LinkedList<String>();
		result.add(name);
		return result;
	}

	public List<File> search(String name) {
		List<File> result = new LinkedList<File>();
		if (this.name.equals(name))
			result.add(this);
		return result;
	}

	public void setParent(AComponent parent) {
		this.parent = parent;
		
	}

	public String toString(){
		String path = parent.toString()+ "/";
		return path + name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	public List<AComponent> toList() {
		List<AComponent> result = new LinkedList<AComponent>();
		result.add(this);
		return result;
	}

	public File(String name, int size) {
		super();
		this.name = name;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	public int size() {
		return size;
	}
}
