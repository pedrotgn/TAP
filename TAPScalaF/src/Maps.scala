/**
 * Created by pedro on 7/29/15.
 */

//http://www.tutorialspoint.com/scala/scala_maps.htm

object Maps {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#C")

    val nums: scala.collection.mutable.Map[Int, Int] = scala.collection.mutable.Map()

    println( "Keys in colors : " + colors.keys )
    println( "Values in colors : " + colors.values )
    println( "Check if colors is empty : " + colors.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )
    println ("color[red]="+colors("red"))

    val result = colors.values map ((x:String)=>x.toLowerCase)

    val result2 = colors.values filter ((y:String) => y.length>3)

    colors.keys.foreach((elem)=>println("key="+elem))


    println(result)
    println(result2)

    //colors("blue")="pedro"
    nums(55) = 100
  }
}