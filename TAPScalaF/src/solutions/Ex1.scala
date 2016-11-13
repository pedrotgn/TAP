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

  def beginsWithA(s:String) = s.startsWith("a")

  def capitals (s:String) = s.toUpperCase


  println (ex2(range.toList,even,elem=>elem*elem))



  val evenapply = ex2(_:List[Int],even,_:Int=>Int)
  println (evenapply(range.toList,elem=>elem*elem))


  def ex3 [T] (f1:T=>Boolean) (f2:T=>T) (l:List[T])= l.filter(f1).map(f2)

  println (ex3 (even) (elem=>elem*elem) (range.toList))

  val evenapply2 = ex3 (even) (elem=>elem*elem) _

  println (evenapply2  (range.toList))

  val lists = List("abc","def","ghi")

  println (ex3 ((elem:String)=>elem.startsWith("a")) ((elem:String)=>elem.toUpperCase()) (lists))
  val evenapply3 = ex3 ((elem:String)=>elem.startsWith("a")) ((elem:String)=>elem.toUpperCase()) _

  println (evenapply3(lists))

  val evenapply4 = ex3 (beginsWithA) (capitals) _

  println (evenapply4(lists))






}