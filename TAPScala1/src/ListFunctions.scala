/**
 * Created by pedro on 17/09/15.
 */

object ListFunctions {

  def add(x:Int,y:Int):Int = x+y

  def show(msg:String): Unit ={
    println(msg)
  }

  def concat(m1:String,m2:String):String = m1++m2

  def show2(a:Any,b:Any) {
    println (a+" "+ b)
  }


  def incr(x:Int):Int = x+1

  def main(args: Array[String]) {
    val ints:List[Int] = List(1,3,5,6,8,9)

    println(ints)

    val ints2 = ints map incr

    println(ints2)

    val ints3 = ints map ((elem)=>elem+1)

    println(ints3)

    val odds =  ints filter ((elem)=>elem%2!=0)

    println(odds)

    val sumlist = ints.foldLeft (0) (add)

    println(sumlist)


    val generateList =  List.tabulate(5) (n=>n)


    println(generateList)

  }
}