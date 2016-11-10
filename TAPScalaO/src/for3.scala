/**
 * Created by pedro on 9/16/15.
 */

case class Human2(name:String, likes:String*)


object For3 {


  def main(args: Array[String]) {
    val bob = Human2("bob","read","travel")
    val elle = Human2("elle","wine","read","run","travel")
    val lara = Human2("lara","animals","frenchfilms","poetry")
    val ana = Human2("ana","swim","sing","dance","travel")


    val girls = List(elle,lara,ana)
    //find candidate couples for bob
    val result = for {
      girl <- girls
      matches <- bob.likes
      if (girl.likes.contains(matches))
    } yield girl.name

    println(result)

    val result2 = for {
      girl <- girls
      matches = girl.likes filter ((p)=>bob.likes.contains(p))
      coincidences = matches.length
      if (coincidences>0)
    } yield (girl.name,coincidences)

    println(result2)




  }
}