package visitor;

//ConcreteElement
public class HonoredTaxiVisitor implements TaxiVisitor{

	@Override
	public void visit(HastyPerson e) {
		if (e.veryHasty()){
			System.out.println("I drive as fast as I can");
		}else{
			System.out.println("I drive fast");
		}
	}

	@Override
	public void visit(LeisurelyPerson e) {
		System.out.println("I drive in a natural way");
	}

}
