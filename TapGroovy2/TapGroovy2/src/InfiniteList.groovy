
/**
 * Created by pedro on 02/10/14.
 */


/**
 * Created by pedro on 10/09/14.
 */

class LazyList {
    def car
    private Closure cdr

    LazyList(def car, Closure cdr) { this.car = car; this.cdr = cdr }

    def LazyList getCdr() { cdr ? cdr.call() : null }

    def List take(n) {
        def r = []; def l = this
        n.times { r.add(l.car); l = l.cdr }
        r
    }

    def LazyList filter(Closure pred) {
        if (pred(car))
            return pred.owner.cons(car, { getCdr().filter(pred) })
        else
            return getCdr().filter(pred)
    }

}


def cons(val, Closure c) { new LazyList(val, c) }
// now define and use infinite streams
def integers(n) { cons(n, { integers(n+1) }) }
def naturalnumbers = integers(1)

println naturalnumbers.take(10).join(' ')
def evennumbers = naturalnumbers.filter{ it % 2 == 0 }
println evennumbers.take(10).join(' ')
