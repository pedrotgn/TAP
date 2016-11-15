/**
 * Created by pedro on 10/7/15.
 */



case class Person3(name: String, age: Int)


object ListFunctions2 extends scala.App{


  val persons = Seq(Person3("Young", 17),Person3("MidLifeCrisis", 40),Person3("Wise", 99))

  println(persons.minBy(_.age))
  println(persons.maxBy(_.age))



}
