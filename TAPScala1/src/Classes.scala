/**
 * Created by pedro on 7/29/15.
 */

class Person (val name:String, val age:Int){
}

class Person2 (val name1:String, val age1:Int){
  var name: String = name1
  var age: Int =age1

  def setAge(num:Int): Unit ={
     this.age = num
  }
}


object Classes {
  def main(args: Array[String]) {
    val p = new Person("pedro",41)
    println (p.age)
    //p.age = 79

    val p2 = new Person2("peter",41)
    println (p2.age)
    p2.age  = 89
    p2.setAge(99)




  }
}

