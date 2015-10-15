/**
 * Created by pedro on 10/09/14.
 */

def reduce
reduce = {f, value ,list->
    if (list==[])
        value
    else
        f(list[0],  reduce(f,value, list.tail()))
}
def suma = {x,y->x+y}
println reduce(suma,0,[1,2,3])

reduce2 = {f,value, list->
    if (list==[])
        value
    else
        reduce2(f,f(value,list[0]),list.tail())

}

println reduce2(suma, 0, [1,2,3])
