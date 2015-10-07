/**
 * Created by pedro on 09/09/14.
 */

trait XAnimal {
    def talk() {
        "I am an Animal"
    }
}
trait XPerson {
    def talk(){
        "I am a person"
    }
}

class Mutant implements XAnimal,XPerson{}

def m = new Mutant()

println m.talk() // ???
