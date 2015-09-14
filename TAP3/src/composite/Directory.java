package composite;

import java.util.LinkedList;
import java.util.List;

public class Directory implements AComponent {

	private String name;
	private List <AComponent> children;
	

	public Directory(String name) {
		this.name = name;
		children = new LinkedList<AComponent>();
	}

	public void addChild(AComponent child) {
		children.add(child);

	}

	public void removeChild(AComponent child){
		children.remove(child);
	}



	public int size() {
		int result = 0;
		for (AComponent child:children)
			result = result + child.size();
		return result;
	}
	
}
