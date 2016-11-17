/**
  * Created by pedrotgn on 17/11/2016.
  */


package composite

import scala.collection.mutable.ListBuffer

trait AComponent{
  def size:Int
}


class File(val name:String,val amount:Int) extends AComponent {
  override def size = amount
}


class Directory(val name:String) extends AComponent {
  private var children: ListBuffer[AComponent] = new ListBuffer[AComponent]()

  def addChild(child: AComponent): Unit = {
    children += child
  }

  def removeChild(child: AComponent): Unit = {
    children -= child
  }

  override def size = {
    children.map(_.size).sum
  }

}