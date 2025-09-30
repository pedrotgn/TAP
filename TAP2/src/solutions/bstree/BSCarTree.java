package solutions.bstree;

import java.util.Comparator;

public class BSCarTree<T extends Car> extends BSTree<T> {

    public BSCarTree(Comparator<T> comp) {
        super(comp);
    }

    public BSCarTree(Comparator<T> comp, T data) {
        super(comp, data);
    }

    public void makeAllCarsClaxon() {
        this.forEachNode(Car::claxon);
    }
}
