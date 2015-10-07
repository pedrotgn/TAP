/**
 * Created by pedro on 9/5/14.
 */

def  list = [1,2,3,4,5]
println list.getClass()  //java.util.ArrayList
for (i in list)
    println i
println list.size()
list<<66
println list // [1,2,3,4,5,66]
println list + [98,99,100]  // [1,2,3,4,5,98,99,100]
println list - [3,4]  // [1,2,5,66]
println list << 'hola'  // [1,2,3,4,5,66,hola]