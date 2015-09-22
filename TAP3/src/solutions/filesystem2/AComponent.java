package solutions.filesystem2;

import java.util.List;

public interface AComponent {
	public void ls();
	public List<String> collect();
	public List<AComponent> toList();
	public List<File> search(String name);
	public int size();
	public void setParent(AComponent parent);
	public String getName();
}
