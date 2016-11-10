/**
 * Created by pedro on 7/29/15.
 */


object Functions extends scala.App{

  def add(x:Int,y:Int):Int = x+y

  def show(msg:String): Unit ={
    println(msg)
  }

  def concat(m1:String,m2:String):String = m1++m2

  def show2(a:Any,b:Any) {
      println (a+" "+ b)
  }

  def showgeneric[T](m1:T,m2:T): Unit ={
    println (m1+" "+ m2)
  }




    println(add(1, 3))
    show("showing:"+ concat("HOLA ","AMIGO"))
    show2(3,4)
    show2("a","b")
    showgeneric("a","b")
    showgeneric(1,2)


}