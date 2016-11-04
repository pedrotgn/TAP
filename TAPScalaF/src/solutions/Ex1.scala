/**
  * Created by pedrotgn on 02/11/2016.
  */

/**
  * Created by pedro on 7/29/15.
  */



import scala.collection.mutable.ListBuffer
// http://www.tutorialspoint.com/scala/scala_lists.htm

object Ex1 extends scala.App {



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