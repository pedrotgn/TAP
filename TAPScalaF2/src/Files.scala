/**
 * Created by pedro on 11/24/16.
 */

import scala.io.Source

object Files extends scala.App {



  val src = Source.fromFile("accounts.txt")
  val iter = src.getLines().map(_.split(",")).toList


  src.close()


  iter.foreach((e:Array[String])=>{println("Account: ....");e.foreach(println)})



}