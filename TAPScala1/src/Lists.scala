/**
 * Created by pedro on 7/29/15.
 */

// http://www.tutorialspoint.com/scala/scala_lists.htm

object Lists {
  def main(args: Array[String]) {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
    val nums = Nil

    println( "Head of fruit : " + fruit.head )
    println( "Tail of fruit : " + fruit.tail )
    println( "Check if fruit is empty : " + fruit.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )

    val fruit2 = List("apples2","oranges2","pears2")
    println( "Head of fruit 2 : " + fruit2.head )
    println( "Tail of fruit 2 : " + fruit2.tail )

   println ("banana"::fruit2)
   val list = ("l1"::"l2"::Nil):::fruit2
   println(list)

    for (elem <- list) println(elem)

    println(fruit.maxBy(_.length))

  }
}