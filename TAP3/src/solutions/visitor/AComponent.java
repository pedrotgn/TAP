package solutions.visitor;

import java.util.List;

public interface AComponent {
	public void ls();
	public List<AComponent> toList();
	public void setParent(AComponent parent);
	public void accept(Visitor v);
}
