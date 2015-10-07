/**
 * Created by pedro on 7/29/15.
 */

class YAnimal {
  def talk():String = "I am an animal"
}

class YDog extends YAnimal{
  override def talk():String = "I am a Dog"
}

class YCat extends YAnimal {
  override def talk():String = "I am a cat"
}


object Inheritance {
  def main(args: Array[String]) {
    val  c = new YCat()
    val d = new YDog()
    val a = new YAnimal()
    val farm = c::d::a::Nil
    for (animal <- farm)
        println(animal.talk())


  }
}


