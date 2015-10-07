/**
 * Created by pedro on 10/09/14.
 */

def incr = {it +1}
def list = [1,2,3,4,5]
def list2 = list.collect(incr)
println list2   //  [2,3,4,5,6]

def odd = {it%2==0}
def list3 = list.findAll(odd)
println list3  // [2,4]

def sum = {x,y -> x+y}
def list4 = list.inject(sum)
println list4  //15

[1, 2, 3].each{ println "Item: $it" }

['a', 'b', 'c'].eachWithIndex{ it, i -> println "$i: $it" }
