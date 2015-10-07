/**
 * Created by pedro on 09/09/14.
 */


//Stack recursion
def printdots
printdots = {n -> (n==0)?'': '.' + printdots(n-1)}

//Tail recursion
def plus
plus =  {x,y ->
    (y==0)?x: plus(x+1,y-1)
}


println printdots(5)

println plus (5,6)
