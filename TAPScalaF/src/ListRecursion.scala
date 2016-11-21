import _root_.scala.collection.immutable.::

/**
 * Created by pedro on 9/4/15.
 */


object ListRecursion extends scala.App{

  def length[T](xs:List[T]):Int = xs match {
    case Nil => 0
    case x :: xs => 1 + length(xs)
  }


  def tlength[T](acc:Int, xs:List[T]):Int = xs match {
    case Nil => acc
    case x :: xs => tlength(acc+1,xs)
  }

  def zipWith[T](list: List[T],list2:List[T],f:(T,T)=>T): List[T] = (list,list2) match {
    case (Nil,_) => Nil
    case (a :: b, c::d)  => f(a,c):: zipWith(b,d,f)

  }


  val long = tlength(0,_:List[Any])


    println(length(List(1,2,3,4)))
    println(tlength(0,List(1,2,3,4)))
    println(long(List(1,2,3,4)))
    println(length(List("a","b","c","d","e")))
    println(length("pedro".toList))
    println(zipWith(List(1,2,3),List(4,5,6),(x:Int,y:Int)=>x+y))


}
