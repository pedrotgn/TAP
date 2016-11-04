/**
 * Created by pedro on 7/29/15.
 */



import scala.collection.mutable.ListBuffer
// http://www.tutorialspoint.com/scala/scala_lists.htm

object Lists extends scala.App {

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

    println("Buffer:")
    var l2  = new ListBuffer[String]()
    fruit.foreach(l2+=_)
    l2-="oranges"
    l2.foreach(println)

    var l3 = ListBuffer(2,34,4,5,6,6)
    l3+=999
    l3.foreach(println)



    var il1 = List(1,2,3)
    il1 = il1:+34

    il1 foreach println

    il1 = 66::il1

    il1 foreach println



    val range = 1 to 100
    println(range)



     println (range.filter(_%2!=0).map(elem=>elem*elem))

  def ex2(l:List[Int],f1:Int=>Boolean,f2:Int=>Int):List[Int]= l.filter(f1).map(f2)

  def even(x:Int):Boolean = x%2==0

  println (ex2(range.toList,even,elem=>elem*elem))



  val evenapply = ex2(_:List[Int],even,_:Int=>Int)
  println (evenapply(range.toList,elem=>elem*elem))


  def ex3(f1:Int=>Boolean) (f2:Int=>Int) (l:List[Int])= l.filter(f1).map(f2)

  println (ex3 (even) (elem=>elem*elem) (range.toList))

  val evenapply2 = ex3 (even) (elem=>elem*elem) _

  println (evenapply2  (range.toList))




}