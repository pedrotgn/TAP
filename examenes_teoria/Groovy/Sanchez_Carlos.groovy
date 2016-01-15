import java.util.zip.ZipEntry

/**
 * Created by milax on 29/01/15.
 */

"""
Ejercicio 1. Se trata de realizar un programa de gestiÃ³n de correo electronico.
 Un correo tiene un origen (from), un destino (to), un tema (subject), un cuerpo (body) y un tipo (URGENT, WORK, FAMILY).

Dada una lista de correos calculad:

"""

enum Type{URGENT, WORK, FAMILY}

class correo{
    def origen, destino, tema, cuerpo
    Type tipo

    def String toString(){
        'from:'+origen
    }
}

correo1 = new correo(origen:'pedro', destino:'susana', tema:'TAP', cuerpo:'examenes', tipo:Type.WORK)
correo2 = new correo(origen:'carlos', destino:'natalia', tema:'dinar', cuerpo:'cretino', tipo:Type.FAMILY)
correo3 = new correo(origen:'andres', destino:'pep', tema:'Entrega', cuerpo:'cretino', tipo:Type.URGENT)
correo4 = new correo(origen:'raul', destino:'susana', tema:'TAP', cuerpo:'2Q', tipo:Type.WORK)

listaCorreos = [correo1, correo2, correo3, correo4]


//1. Crear una funciÃ³n getMails(kind,lista) que devuelva una lista con todos los mails del tipo pasado por parÃ¡metro.

def getMails = {kind, lista->
    lista.findAll({it.tipo==kind})
}

println getMails(Type.URGENT, listaCorreos)


//2. Parametrizar parcialmente getMails para que retorne los mails de trabajo

def getMails2 = getMails.curry(Type.WORK)
println getMails2(listaCorreos)


// 3.  Obtener de la lista los correos que contengan la palabra cretino en el body

println listaCorreos.findAll({it.cuerpo=='cretino'})


//4. Obtener de dos formas diferentes la lista de gente con la que nos comunicamos en el mailbox (to)


//manera 1
def map(f,list) {
    result = []
    if (list==[]){
        []
    }else{
        result<<map(f,list.tail())
        result.add(0,f(list[0]))
        result
    }
}

def to = {x->println 'to:' +x}
map(to,listaCorreos.destino)


//manera2
listaCorreos.destino.collect(to)


//5. Calculad el tamaÃ±o total del mailbox sumando los tamaÃ±os del body de cada mensaje

def sum = {x,y -> x+y}
println listaCorreos.cuerpo.inject(sum).size()



//6. Implementar la funcion filterreduce en groovy con recursividad de pila y acumulativa.
//  Usadla para calcular la suma de los numeros pares de una lista

def lista = [1,2,3,4,5,6,7,8,9,10]

//pila
def filterreduce
filterreduce = {list ->
    (list==[])?0:list.head()+filterreduce(list.tail())
}

def odd = {it%2==0}
println filterreduce(lista.findAll(odd))


//acumulativa
def filterreduce2
filterreduce2 = {acc,list ->
    (list==[])?acc:filterreduce2(acc+list.head(),list.tail())
}

println filterreduce2(0, lista.findAll(odd))

//acumulativa2
/*
def reduce2
reduce2 = {f,value, list->
    if (list==[])
        value
    else
        reduce2(f,f(value,list[0]),list.tail())

}

println reduce2(odd, 0, lista)
*/


// Ejercicio 2. Implementar un Ã¡rbol de ficheros y directorios en Groovy. Un directorio contiene ficheros y directorios.
// Un fichero tiene un nombre y un tamaÃ±o. Un directorio tiene un nombre y una lista de ficheros y directorios.
// a) Queremos una funcion que planarice el arbol a una lista.
// b) AÃ±adir una funcion reduce al arbol que permita aplicarle una funciÃ³n y obtener un resultado. Usadla para
// obtener el fichero mas grande del arbol
// c) AÃ±ade el metodo toList usando metaprogramming
// d) AÃ±ade el metodo toList usando Traits.

class Tree{
    def left, right
    def children
}

class fichero{
    def nombre, tamaño
}

class directorio{
    def listaficheros, nombre
}


def flattern