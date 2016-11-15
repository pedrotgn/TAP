
trait Talkable {
  def talk():String {}
}

trait XAnimal extends Talkable {
  override def talk():String = "I am an Animal"
}

trait XPerson {
   def say():String = "I am a person"
}

class Mutant extends XAnimal with XPerson
class Alien (name:String)

object MultipleInheritance {
  def main(args: Array[String]) {
    val m = new Mutant()
    println (m.talk())
    val et = new Alien("ET") with XAnimal with XPerson
    println(et.say())
    println(et.talk())
  }

}




