/**
 * Created by pedro on 9/4/15.
 */

case class Robot(name:String,age:Int)

object PMap extends scala.App{

  def pmap[T,S](f:(T => S), xs:List[T]):List[S] = xs match {
    case Nil => Nil
    case x :: xs => f(x) :: pmap(f,xs)
    }

  def pmap2[T,S](f:(T => S))  (xs:List[T]):List[S] = xs match {
    case Nil => Nil
    case x :: xs => f(x) :: pmap2 (f) (xs)
  }

  def incr (x:Int) = x + 1


  val humans:List[Robot] = List(Robot("pedro",2),Robot("pep",5),Robot("pau",1))

  println (pmap(incr,List(1,2,3)))

  println (pmap((h:Robot)=>h.name,humans))

  println(humans.map(_.name))
  println(humans.map(_.age).sum)



  val mapincr = pmap(incr,_:List[Int])

  println (mapincr(List(1,2,3)))

  println(pmap ((x:Int)=>x+1,List(1,2,3)))

  println (pmap2(incr) (List(1,2,3)) )

  val mapincr2 = pmap2(incr) _

  println (mapincr2(List(1,2,3)))



}
