/**
 * Created by pedro on 11/12/15.
 */


import org.scalatest.FunSuite


import PMap.pmap

class PMapSuite extends FunSuite {

  // Fix this error !!!

  test("pmap is invoked in an empty list") {

   val result = pmap((s:Int)=>s+1,List())
    assert(result === 0)
  }


}