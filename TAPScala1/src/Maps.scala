/**
 * Created by pedro on 7/29/15.
 */

//http://www.tutorialspoint.com/scala/scala_maps.htm

object Maps {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")

    val nums: Map[Int, Int] = Map()

    println( "Keys in colors : " + colors.keys )
    println( "Values in colors : " + colors.values )
    println( "Check if colors is empty : " + colors.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )
    println ("color[red]="+colors("red"))




  }
}