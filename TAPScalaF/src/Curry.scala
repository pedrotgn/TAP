/**
 * Created by pedro on 17/09/15.
 */


object Curry extends scala.App{

  def convert(name:String) (f:(String=>String)):String = {
    f(name)
  }

  def capital = (elem:String)=>elem.toUpperCase



    val result = convert ("pedro") ((elem)=>elem.toUpperCase)

    println(result)

    val f2 = convert ("pepe") _

    println(f2(capital))

    val f3 = convert (_:String) (capital)

    println(f3("aprobare tap"))




}