/**
 * Created by pedro on 10/7/15.
 */


case class Human2(name:String, age:Int)

object ListObject extends App{

  val l:List[Human2]=List(Human2("pedro",11),Human2("pere",34),Human2("mer",23))

  val result = l.filter(_.name.startsWith("p"))

  result.foreach(println)




}

