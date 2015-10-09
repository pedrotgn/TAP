package solutions.visitor;

import java.util.LinkedList;
import java.util.List;

public class OwnerVisitor extends Visitor {


	private String owner;
	private List<File> results;
	
	public OwnerVisitor(String owner) {
		results = new LinkedList<File>();
		this.owner = owner;
	}

	@Override
	public void visit(File file) {
		if (file.getOwner().equals(owner))
			results.add(file);

	}

	public List<File> getResults() {
		return results;
	}


}
