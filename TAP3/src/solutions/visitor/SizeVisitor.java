package solutions.visitor;

public class SizeVisitor extends Visitor {

	private int size = 0;
	
	
	
	public int getSize() {
		return size;
	}


	@Override
	public void visit(File file) {
		size+= file.getSize();

	}


}
