/**
 * Created by pedro on 7/29/15.
 */


object Conditionals extends scala.App{

    val news = if (true)
      "good"
    else
      "bad"

    if (true) {
      println("foo was true")
    }

    news match {
      case "good" => println("Good news!")
      case "bad" => println("Bad news!")
    }

    for (i<-0 to 6)
      println (i)


}

