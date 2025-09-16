package solutions.structures;

public class Client implements Comparable<Client>{
	private String name;
	private int age;

	public Client(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

    @Override
    public int compareTo(Client o) {
        return name.compareTo(o.name);
    }
}