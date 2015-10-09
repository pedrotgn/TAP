package solutions.visitor;

import java.util.LinkedList;
import java.util.List;

public class SearchVisitor extends Visitor {

	private String name;
	private List<File> results;
	
	public SearchVisitor(String name) {
		results = new LinkedList<File>();
		this.name = name;
	}

	@Override
	public void visit(File file) {
		if (file.getName().equals(name))
			results.add(file);

	}

	public List<File> getResults() {
		return results;
	}


	

}
