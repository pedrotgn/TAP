package solutions

/**
 * Created by pedro on 9/4/15.
 */

object Reduce {

  def preduce[T](result:T,f:(T,T) => T, xs:List[T]):T = xs match {
    case Nil => result
    case x :: xs => f(x,preduce(result,f,xs))
  }


  def main(args: Array[String]) {
    def sum (x:Int,y:Int) = x + y

    println (preduce(0,sum,List(1,2,3)))

    val sumr = preduce(0,sum, _:List[Int])

    println (sumr(List(1,2,3)))

    println(preduce (0,(x:Int,y:Int)=>x+y,List(1,2,3)))


    println(List(1,2,3,4).foldRight (0) (sum))

    println(List(1,2,3,4).foldLeft (0) (sum))





  }
}
