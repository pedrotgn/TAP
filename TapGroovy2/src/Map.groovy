/**
 * Created by pedro on 10/09/14.
 */
def map
map = {f,list->
    result = []
    if (list==[]){
        []
    }else{
        result<<map(f,list.tail())
        result.add(0,f(list[0]))
        result
    }
}

def map2(f,list) {
    result = []
    if (list==[]){
        []
    }else{
        result<<map2(f,list.tail())
        result.add(0,f(list[0]))
        result
    }
}

def incr = {x->x+1}
println map(incr,[1,2,3])
def mapinc = map.curry(incr)
println mapinc([6,7,8])

// def mapinc2 = map2.curry(incr) //ERROR
def map3 = this.&map2
def mapinc3 = map3.curry(incr)
println mapinc3([6,7,8])