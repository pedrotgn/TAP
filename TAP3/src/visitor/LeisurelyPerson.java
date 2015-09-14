package visitor;

//ConcreteElement
public class LeisurelyPerson implements Person{

	private int smile; //how big is his smile
	
		
	public LeisurelyPerson(int smile) {
		super();
		this.smile = smile;
	}

	@Override
	public void accept(TaxiVisitor v) {
		v.visit(this);
	}

	public boolean bigSmile() {
		return (smile>5);
	}
	
}
