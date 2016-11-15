/**
 * Created by pedro on 10/8/15.
 */


class Monster[T](
                private var name:String, private var monster:T){
  def getName:String=name
  def getMonster:T = monster
  def setMonster(newM:T)=monster=newM
}

case class Dino[T](name:String,queue:T)

object Run extends scala.App{

  def show[T](monster:T)=println(monster)


  val t = new Monster("pedro","Beast")
  println(t.getMonster)
  t.setMonster("TAP")
  println(t.getMonster)

  show("pepe")
  show(121212)

  val d = Dino("dino1",9897)
  println(d.queue)

  val d2 = Dino("dino2","elephant")
  println(d2.queue)



}