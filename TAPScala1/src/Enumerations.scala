/**
 * Created by pedro on 10/7/15.
 */

object Main extends scala.App {
  object WeekDay extends Enumeration {
   type WeekDay = Value
   val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
   def valueOf(name: String) = WeekDay.values.find(_.toString == name).get
  }


  import WeekDay._
  def isWorkingDay(d: WeekDay) = ! (d == Sat || d == Sun)

  WeekDay.values filter isWorkingDay foreach println

  println(WeekDay.valueOf("Sat"))

}