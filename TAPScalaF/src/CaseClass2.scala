/**
  * Created by pedrotgn on 01/11/2016.
  */


case class Car(brand: String, cost: Int)

object CarTest extends scala.App {


  val bmw = Car("bmw",100)
  println(bmw.brand)
  println(bmw.cost)

  val cars = List(bmw,Car("seat",10),Car("fiat",10))


  println (cars.filter(_.cost==10))

  println (cars.filter(car=>car.cost==10))





}
