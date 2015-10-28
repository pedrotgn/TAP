/**
 * Created by pedro on 10/14/15.
 */


case class Car (var name:String,var cost:Int)

object Meta extends scala.App {

  implicit class StringImprovements(s: String) {
    def increment = s.map(c => (c + 1).toChar)
  }
    implicit class CarImprovements(c: Car) {
      def increment = c.cost=c.cost+1
  }





  val c = new Car("bmw",999)

  println("HAL".increment)
  c.increment
  println(c)



}
