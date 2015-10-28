/**
 * Created by pedro on 9/16/15.
 * See Programming in Scala, Chapter 23
 */


case class Book(title:String, authors:String*)

object ForExpressions2 {

  def main(args: Array[String]) {
    val books:List[Book] =
    List(
      Book(
      "First Book",
      "Auth1","Auth2","Auth3"
      ),
      Book(
       "Second Book",
        "Asi","Pepe","Pau"
      ),Book(
       "Third Book",
        "Asi","mov","robot"
      ),Book(
       "Fourth Book",
        "ready","player","one"
      )
    )

    val query1 = for (b <- books; a <- b.authors if a startsWith "Asi") yield b.title
    println(query1)


    val query2 = for {
      b <- books
      a <- b.authors
      if a startsWith "Asi"
    } yield b.title
    println(query2)


    /*
    val z2 = for {
      p <- persons
      n = p.name
      if (n startsWith "Bo")
    } yield n

    println (z2)
*/

  }
}