package solutions.visitor;

public abstract class Visitor {
	 public abstract void visit(File file);
	 public void visit(Directory dir){
		 for (AComponent elem:dir.getChildren())
				elem.accept(this);
	 }

}
