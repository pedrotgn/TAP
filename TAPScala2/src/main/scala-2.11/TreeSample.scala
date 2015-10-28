/**
 * Created by pedro on 9/8/15.
 */

abstract class ITree
case class Tree(left:ITree,value:Int,right:ITree) extends ITree
case class TNil() extends ITree


object TreeSample {
/*
  def pmap[T](f:(T => T), xs:List[T]):List[T] = xs match {
    case Nil => Nil
    case x :: xs => f(x) :: pmap(f,xs)
  }
*/

  def tree2List(x:ITree):List[Int] = x match {
    case TNil() => List()
    case Tree(a, b, c) => tree2List(a) ++ List(b) ++ tree2List(c)
  }

  def main(args: Array[String]) {

    val a1 = Tree(TNil(),3,Tree(TNil(),5,TNil()))

    val a2 = Tree(Tree(Tree(TNil(),2,TNil()),5,TNil()),3,Tree(TNil(),5,TNil()))

    println(tree2List(a1))

    println(tree2List(a2))


  }
}
