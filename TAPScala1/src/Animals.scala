/**
 * Created by pedro on 7/29/15.
 */

class Animal {
  def talk():String = "pedro"
}
class Duck extends Animal {
  def cuac():String = "cuac"
}


object TestAnimals {
  def main(args: Array[String]) {
    val a = new Duck()
    println (a.cuac())
  }
}
