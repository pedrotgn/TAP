package visitor2;

/**
 * Created by milax on 14/10/16.
 */
 interface ComputerPartVisitor {
     void visit(Computer computer);
     void visit(Mouse mouse);
     void visit(Keyboard keyboard);
     void visit(Monitor monitor);
}