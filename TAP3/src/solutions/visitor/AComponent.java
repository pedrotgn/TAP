package solutions.visitor;

import java.util.List;

 interface AComponent {
	 void ls();
	 List<AComponent> toList();
	 void setParent(AComponent parent);
	 void accept(Visitor v);
}
