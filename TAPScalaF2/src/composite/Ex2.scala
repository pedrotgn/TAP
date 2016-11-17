/**
  * Created by pedrotgn on 17/11/2016.
  */



package composite

import scala.io.Source

case class Account(id :String, owner:String, kind:String, balance:Long)

object Ex2 extends scala.App {

  val src = Source.fromFile("accounts.txt")
  val iter = src.getLines().map(_.split(",")).toList
  src.close()

  def getAccount(line: Array[String]): Account = Account(line(0), line(1), line(2), line(3).toLong)

  val accounts = iter.map(line => getAccount(line))
  accounts.foreach(println)

  println("Ex1:MAP")
  val result1 = accounts.map(a => Account(a.id, a.owner, a.kind, a.balance + 10))
  result1.foreach(println)

  println("Ex2:FILTER")
  val result2 = accounts.filter(a => a.kind.equals("IF"))
  result2.foreach(println)

  val maxAccount = accounts.maxBy(_.balance)

  println("Ex3: MAX")
  println(maxAccount)
}