/**
 * Created by pedro on 9/4/15.
 */

object Recursion extends scala.App{

  def printdots (n:Int):String = if (n==0) "" else "." ++ printdots(n-1)

  def plus (x:Int,y:Int):Int = if (y==0) x else plus(x+1,y-1)

  def printdots2(n:Int):String = n match {
    case 0 => ""
    case _ => "." ++ printdots2(n-1)
  }

  def plus2(x:Int,y:Int):Int = y match {
    case 0 => x
    case _ => plus2(x+1,y-1)
  }

  println(printdots(3))
  println(plus(3,4))
  println(printdots2(3))
  println(plus2(3,4))





}
