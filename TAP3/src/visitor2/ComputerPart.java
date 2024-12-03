package visitor2;

/**
 * Created by milax on 14/10/16.
 */
 interface ComputerPart {
     void accept(ComputerPartVisitor computerPartVisitor);
}
