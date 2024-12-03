package visitor;

import java.util.LinkedList;


public class Main {

	public static void main(String[] args) {
		TaxiVisitor taxiDriver = new HonoredTaxiVisitor();
		
		LinkedList<Person> clients = new LinkedList<>();
		clients.add(new HastyPerson(5));
		clients.add(new LeisurelyPerson(8));
		
		for (Person client:clients){
			client.accept(taxiDriver);
		}
		
		System.out.println("---");
		
		taxiDriver = new CorruptTaxiVisitor();
		for (Person client:clients){
			client.accept(taxiDriver);
		}
	}

}
