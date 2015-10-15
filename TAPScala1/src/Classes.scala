/**
 * Created by pedro on 7/29/15.
 */

class Person (val name:String, val age:Int){
  override def toString:String = "Person("+name+","+age+")"
}

class Person2 (val name:String, var age:Int){
  override def toString:String = "Person("+name+","+age+")"
}


object Classes {
  def main(args: Array[String]) {
    val p = new Person("pedro",41)
    println (p)
    //p.age = 79

    val p2 = new Person2("peter",41)
    p2.age  = 89
    println(p2)
  }
}

