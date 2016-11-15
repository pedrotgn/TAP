/**
  * Created by pedrotgn on 15/11/2016.
  */

trait Sender {
  def send(s:String):Unit
}

class Console extends Sender{
  override def send(s:String):Unit = { println ("sending " + s) }
}

trait InsultDecorator extends Sender {
  abstract override def send(s:String):Unit = super.send(s+" bastard")
}

trait LoveDecorator extends Sender {
  abstract override def send(s:String):Unit = super.send(s+" love")
}

trait CensorDecorator extends Sender {
  abstract override def send(s:String):Unit = super.send(s.replaceAll("bastard","censored"))

}

object Decorator extends scala.App {
  val c = new Console() with CensorDecorator with InsultDecorator with LoveDecorator
  c.send("HOLA AMIGO ")

}
