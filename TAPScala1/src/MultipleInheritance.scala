/**
 * Created by pedro on 7/29/15.
 */

trait Talkable {
  def talk():String {}
}

trait XAnimal extends Talkable {
  override def talk():String = "I am an Animal"
}

trait XPerson extends Talkable {
  override def talk():String = "I am a person"
}

class Mutant extends XAnimal with XPerson{}

object MultipleInheritance {
  def main(args: Array[String]) {
       val m = new Mutant()
       println (m.talk())
  }

}




