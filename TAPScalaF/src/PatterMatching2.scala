/**
 * Created by pedro on 10/6/15.
 */

object MatchTest2 extends scala.App {
  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
  }
  println(matchTest("two"))
}