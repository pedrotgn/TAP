/**
 * Created by pedro on 7/29/15.
 */

//http://www.tutorialspoint.com/scala/scala_maps.htm

object Maps extends scala.App {

    val colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#C")



   /* def mergeMaps(m1:Map[String,Int],m2:Map[String,Int]):Map[String,Int] = {
      m1.

    }*/


    val newcolors = colors + ("pedro"->"#e343400")

    println(newcolors)


    val numbers = Map("red" -> 1,
      "azure" -> 2,
      "peru" -> 2)



    val numbers2 = numbers + ("red"->6)
    println(numbers2)



    for ((k,v) <- numbers) printf("key: %s, value: %s\n", k, v)


    // version 1 (tuples)
    numbers foreach (x => println (x._1 + "-->" + x._2))

    // version 2 (foreach and case)
    numbers foreach {case (key, value) => println (key + "-->" + value)}




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