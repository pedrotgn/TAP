/**
 * Created by pedro on 10/09/14.
 */

List.metaClass.rightShift = {elem ->
    delegate.add(0,elem)
    delegate
}

def list = [1,2,3,4]
print list>>0  // [0,1,2,3,4]

def map(f,list) {
    (list==[])?[]:map(f,list.tail())>>f(list[0])
}