/**
 * Created by pedro on 17/09/15.
 */



object Closures2 {

  def convert(name:String,f:(String=>String)):String = {
      f(name)
  }


  def convert2 [T] (name:T,f:(T=>T)):T = {
    f(name)
  }

  def main(args: Array[String]) {

    println(convert("pedro",(elem)=>elem.toUpperCase))


    println(convert2("pedro",(elem:String)=>elem.toUpperCase))
    println(convert2(76868,(elem:Int)=>elem*elem))


  }
}