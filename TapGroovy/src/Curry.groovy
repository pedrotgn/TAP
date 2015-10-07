/**
 * Created by pedro on 09/09/14.
 */

def f = {x,y->
    x+y
}

def v = f.curry(3)

println v(5)

def numbers = [1,3,5,6,7,8,3,5,8,9,12,34,55,2,34]

def notRepeated = {list,elem->
    if (list.contains(elem)){
        false
    }else{
        list<<elem
        true
    }
}

def list = []
def unique = notRepeated.curry(list)

println numbers.findAll(unique).sort()






