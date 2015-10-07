/**
 * Created by pedro on 09/09/14.
 */

def f  = {println 'hola'}
f()

def f2 = {x -> println x}
f2('hola')

def suma = {x,y -> x+y}
println suma(3,4)