/**
 * Created by pedro on 10/09/14.
 */

// Stack recursion
def length
length = {list ->
    (list==[])?0:1+length(list.tail())
}
//Tail recursion


def tlength
tlength = {acc,list ->
    (list==[])?acc:tlength(acc+1,list.tail())
}
def tlong = tlength.curry(0)




println length([1,2,3,4,5,6])
println tlength(0,[1,2,3,4,5,6])
println tlong([1,3,4,5,6])
println length("pedro".toList())
