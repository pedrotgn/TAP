/**
 * Created by pedro on 9/5/14.
 */

class Animal {
    def talk(){
        'pedro'
    }
}
class Duck extends Animal {
    def cuac(){
        'cuac'
    }
}

Animal a = new Duck()
println a.cuac()