package solutions.filesystem;

import java.util.List;

 interface AComponent {
	 void ls();
	 List<String> collect();
	 List<AComponent> toList();
	 List<File> search(String name);
	 int size();
	 void setParent(AComponent parent);
}
