package visitor;

public class CorruptTaxiVisitor implements TaxiVisitor{

	@Override
	public void visit(HastyPerson e) {
		if (e.veryHasty()){
			System.out.println("I drive slowly. Clink clink clink...");
		}else{
			System.out.println("I drive very slowly. Clink clink clink...");
		}
		
	}

	@Override
	public void visit(LeisurelyPerson e) {
		if (e.bigSmile()){
			System.out.println("I drive as slowly as I can. Clink clink clink...");
		}else{
			System.out.println("I drive very slowly. Clink clink clink...");
		}
	}
	
}