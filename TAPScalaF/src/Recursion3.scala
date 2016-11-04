/**
 * Created by pedro on 10/7/15.
 * http://alvinalexander.com/scala/scala-recursion-examples-recursive-programming
 */

import scala.annotation.tailrec

object Max extends scala.App {

  val list = List.range(1, 100000)
  println(max(list))
  println(max2(list))

  // 1 - using `match`
  def max(ints: List[Int]): Int = {
    @tailrec
    def maxAccum(ints: List[Int], theMax: Int): Int = {
      ints match {
        case Nil => theMax
        case x :: tail =>
          val newMax = if (x > theMax) x else theMax
          maxAccum(tail, newMax)
      }
    }
    maxAccum(ints, 0)
  }

  // 2 - using if/else
  def max2(ints: List[Int]): Int = {
    @tailrec
    def maxAccum2(ints: List[Int], theMax: Int): Int = {
      if (ints.isEmpty) {
        return theMax
      } else {
        val newMax = if (ints.head > theMax) ints.head else theMax
        maxAccum2(ints.tail, newMax)
      }
    }
    maxAccum2(ints, 0)
  }

}