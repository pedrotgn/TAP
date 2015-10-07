/**
 * Created by pedro on 09/09/14.
 */

class YAnimal {
    def talk(){
        "I am an animal"
    }
}
class YDog extends Animal{
    def talk(){
        "I am a Dog"
    }
}

class YCat extends Animal {
    def talk(){
        "I am a cat"
    }
}
def c = new YCat()
def d = new YDog()
def a = new YAnimal()
def farm = [a,d,c]  // farm << 'hola' ?????
for (animal in farm)
    println animal.talk()