/**
 * Created by pedro on 09/09/14.
 */

def f2 = {x -> println x}
def printList(list, f){
    for (elem in list)
        f(elem)
}
printList([1,2,3,4],f2)
