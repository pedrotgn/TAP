package generics;

public class Thing2<T extends Animal>
{
	private T name;

	public Thing2(T name){
         this.name = name;
	}

	public void setName(T name){
        this.name = name;
	}
	public T getName() {
        return name;
	}
}
