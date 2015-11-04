/**
 * Created by pedro on 04/11/15.
 */



class Human(name:String,age:Int){
  override def toString:String = "human with name:"+name+" and age:"+age
}

case class Robot(name:String,age:Int)


object Human{
  val legs = 2

  def saySomething = println("hi world")

}



object RunObject extends scala.App{


  val h1 = new Human("hans",44)
  println(h1)

  val r1 = Robot("h2d2",1234)
  println(r1)

  println("humans have "+Human.legs + " legs")
  Human.saySomething

}
