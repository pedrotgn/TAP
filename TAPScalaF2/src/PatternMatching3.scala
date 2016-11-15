/**
 * https://kerflyn.wordpress.com/2011/02/14/playing-with-scalas-pattern-matching/
 */


object Patterns extends scala.App {
  def fact(n: Int): Int =
    if (n == 0) 1
    else n * fact(n - 1)

  def fact2(n: Int): Int = n match {
    case 0 => 1
    case n => n * fact2(n - 1)
  }

  def sum(list : List[Int]) : Int = list match {
    case x :: xs => x + sum(xs)
    case Nil => 0
  }

  def length[A](list : List[A]) : Int = list match {
    case _ :: tail => 1 + length(tail)
    case Nil => 0
  }


  println(fact(9))
  println(fact2(9))
  println(sum(List(1,2,3,44)))
  println(length(List(4,6,7,8,9,3)))

}

