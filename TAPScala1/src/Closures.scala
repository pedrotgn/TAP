/**
 * Created by pedro on 17/09/15.
 */


object Closures {



  def main(args: Array[String]) {

    val f = (elem:String)=> println(elem)

    f("pedro")


    val f2 = ((elem:Any)=> println(elem))

    f2("hola")
    f2(2323)

    val sum = (x:Int,y:Int)=>x+y

    println(sum(8,9))


    val longf = (elem:String) => {
      val capitals = elem.toUpperCase
      capitals.length
    }

   println(longf("papanatas"))

  }
}