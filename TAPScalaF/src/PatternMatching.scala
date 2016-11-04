

/**
 * http://docs.scala-lang.org/tutorials/tour/pattern-matching.html
 */


object MatchTest1 extends scala.App {
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  println(matchTest(3))
}