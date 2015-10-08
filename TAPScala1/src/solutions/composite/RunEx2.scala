
package composite
/**
 * Created by pedro on 10/8/15.
 */




object RunEx2 extends scala.App{
  val root: Directory = new Directory("root")
  val home: Directory = new Directory("home")
  val tap: Directory = new Directory("tap")
  val f1: File = new File("f1", 1234)
  val f2: File = new File("f2", 3445)
  val f3: File = new File("f3", 6688)
  val f4: File = new File("lp", 99999)
  root.addChild(home)
  root.addChild(f1)
  home.addChild(tap)
  home.addChild(f2)
  tap.addChild(f3)
  root.addChild(f4)



  println("-------------")

  println("Root SIZE:" + root.size)
  println("Home SIZE:" + home.size)
  println("TAP SIZE:" + tap.size)

}