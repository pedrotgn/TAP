/**
 * Created by pedro on 9/4/15.
 */

object Map extends scala.App{

  def pmap[T](f:(T => T), xs:List[T]):List[T] = xs match {
    case Nil => Nil
    case x :: xs => f(x) :: pmap(f,xs)
    }

  def pmap2[T](f:(T => T))  (xs:List[T]):List[T] = xs match {
    case Nil => Nil
    case x :: xs => f(x) :: pmap2 (f) (xs)
  }

  def incr (x:Int) = x + 1

  println (pmap(incr,List(1,2,3)))

  val mapincr = pmap(incr,_:List[Int])

  println (mapincr(List(1,2,3)))

  println(pmap ((x:Int)=>x+1,List(1,2,3)))

  println (pmap2(incr) (List(1,2,3)) )

  val mapincr2 = pmap2(incr) _

  println (mapincr2(List(1,2,3)))



}
