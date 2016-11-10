/**
 * Created by pedro on 7/29/15.
 */


class YAnimal (legs:Int){
  def talk():String = "I am an animal"
}

class YDog(legs:Int,ears:Int) extends YAnimal(legs:Int){
  override def talk():String = "I am a Dog with "+ears + " ears"
}

class YCat(legs:Int) extends YAnimal(legs:Int) {
  override def talk():String = "I am a cat"
}


object Inheritance {
  def main(args: Array[String]) {
    val  c = new YCat(4)
    val d = new YDog(4,3)
    val a = new YAnimal(4)
    val farm = List(c,d,a)
    for (animal <- farm)
      println(animal.talk())


  }
}



