package visitor;

//ConcreteElement
public class HastyPerson implements Person{
	
	private int clockFrequency; //how often he looks at his clock
			
	public HastyPerson(int clockFrequency) {
		super();
		this.clockFrequency = clockFrequency;
	}

	@Override
	public void accept(TaxiVisitor v) {
		v.visit(this);
	}

	public boolean veryHasty() {
		return (clockFrequency>4);
	}

}
