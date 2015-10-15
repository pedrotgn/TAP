/**
 * Created by pedro on 7/29/15.
 */



object TestAnimals extends scala.App{

  class Animal {
    def talk():String = "hi"
  }
  class Duck extends Animal {
    override def talk():String = "cuac"
  }
  class Dog extends Animal {
    override def talk():String = "guau"
  }

  val farm  = List(new Animal(),new Duck(),new Dog())
  for (a <- farm)
     println(a.talk())

  farm.foreach(a=>println(a.talk()))

}
